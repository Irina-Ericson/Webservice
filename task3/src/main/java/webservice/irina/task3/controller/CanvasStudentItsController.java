package webservice.irina.task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservice.irina.task3.dto.CanvasdataResponse;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.model.StudentIts;
import webservice.irina.task3.model.StudentItsProjection;
import webservice.irina.task3.repo.CanvasRepo;
import webservice.irina.task3.repo.StudentItsRepo;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/canvasstudent")

@RestController
public class CanvasStudentItsController {

    @Autowired
    private StudentItsRepo studentItsRepo;

    @Autowired
    private CanvasRepo canvasRepo;

    @PostMapping("/saveresult")
    public StudentIts studentIts (@RequestBody StudentIts st){
        return studentItsRepo.save(st);
    }

    @GetMapping("/findAllStudents")
    public List<StudentItsProjection> findAllOrders(){
        return studentItsRepo.findAllData();
    }

    @Transactional
    @GetMapping("/getInfo")
    public List<Canvasdata[]> getJoinInformation(){

        return canvasRepo.getJoinInformation();


    }




    }

