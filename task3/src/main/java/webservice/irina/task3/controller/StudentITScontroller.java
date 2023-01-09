package webservice.irina.task3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservice.irina.task3.exception.ResourceNotFoundException;
import webservice.irina.task3.model.StudentIts;
import webservice.irina.task3.model.StudentItsProjection;
import webservice.irina.task3.repo.StudentItsRepo;
import webservice.irina.task3.service.StudentItService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/studentITS", produces="application/json")
@RestController

public class StudentITScontroller {
    @Autowired
    public StudentItService studentItService;

    @Autowired
    public StudentItsRepo studentITSrepo;

    private final Logger debugLogger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @GetMapping("/student")
    public List<StudentItsProjection> getAllStudents() {
        return studentITSrepo.findAllData();
    }


    @PostMapping("/student")
    public StudentIts createStudent(@RequestBody StudentIts st) {
        return studentITSrepo.save(st);
    }

    @GetMapping("/{s_id}")
    public ResponseEntity<StudentIts> getAllStudents(@PathVariable Long id) {
        StudentIts st = (StudentIts) studentITSrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student finns inte med id :" + id));
        return ResponseEntity.ok(st);
    }

    @GetMapping("myStudent/{studentID}")
    public List findPnrByStudentID(@PathVariable ("studentID") String studentID) {
        List st = studentITSrepo.getPnrByStudentID(studentID);

        return st;
    }

    @PutMapping(value = "/saveStudent")
    @ResponseBody
    ResponseEntity<StudentIts> saveStudent(@PathVariable("id") Long id, @RequestBody StudentIts st) {
        Optional<StudentIts> studentOptional = studentITSrepo.findStudentById(id);

        if (studentOptional.isPresent()) {
            StudentIts _st = studentOptional.get();
            _st.setStudentnamn(st.getStudentnamn());
            _st.setPersonnummer(st.getPersonnummer());
            _st.setStudentID(st.getStudentID());
            _st.setLosenord(st.getLosenord());
            _st.setEpostadress(st.getEpostadress());
            return new ResponseEntity<>(studentITSrepo.save(_st), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}




