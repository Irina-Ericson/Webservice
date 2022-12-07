package webservice.irina.task3.model;

import java.util.Date;
import java.util.List;

public interface CanvasResultProjection {

    String getC_id();
    //namn Canvas
    String getStudentnamn();
    //omdome Canvas
    String getOmdome();

    String getKursnamn();

    String getUppgift();

    //data from Ladokdata
    List<LadokResultProjection> getLadokdata();
    //Betyg Ladok
    String getResultat();
    //Datum Ladok
    Date getRegistrDatum();
    //status Ladok
    String getStatus();
    //Information Ladok
    String getInformation();
    //personnummer Ladok
    String getPersonnummer();




    }
