package webservice.irina.task3.model;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface StudentItsProjection {



    @Value("#{target.student_id}")
    String getStudentID();
    String getLosenord();

     @Value("#{target.personnummer}")
    String getPersonnummer();


    List<CanvasProjection> getCanvasdata();

    }
