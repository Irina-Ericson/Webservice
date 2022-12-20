package webservice.irina.task3.model;

import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

public interface LadokResultProjection {


    @Value("#{target.resultat}")
    String getResultat();

    @Value("#{target.registrdatum}")
    String getRegistrDatum();

    @Value("#{target.status}")
    String getStatus();

    @Value("#{target.information}")
    String getInformation();

    @Value("#{target.personnummer}")
    String getPersonnummer();

    @Value("#{target.id}")
    Long getId();


    List<CanvasResultProjection> getCanvasdata();


}
