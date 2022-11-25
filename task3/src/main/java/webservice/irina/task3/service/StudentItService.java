package webservice.irina.task3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import webservice.irina.task3.model.StudentIts;

import webservice.irina.task3.model.StudentItsProjection;
import webservice.irina.task3.repo.StudentItsRepo;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Service

public class StudentItService {

    private final StudentItsRepo studentITSrepo;

    @Autowired
    public StudentItService(StudentItsRepo studentITSrepo) {
        this.studentITSrepo = studentITSrepo;
    }

   public List<StudentIts> getPersonnummer(String studentID) {
        return studentITSrepo.getPnrByStudentID(studentID);
    }

    public List<StudentItsProjection> findAllStudents()
    {return studentITSrepo.findAllData();}


}
