package webservice.irina.task3.model;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CanvasProjection {


    String getStudentID();

    String getKursnamn();

    String getEpostadress();

    List <StudentItsProjection> getStudentIts();

   // @Value("#{target.studentIts.personnummer}")
    String getPersonnummer();


}
