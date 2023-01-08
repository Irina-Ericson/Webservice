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
    void setResultat();
    //Datum Ladok
    Date getRegistr_datum();
    void setRegistr_datum();
    //status Ladok
    String getStatus();
    void setStatus();
    //Information Ladok
    String getInformation();
    void setInformation();
    //personnummer Ladok
    String getPersonnummer();
    void setPersonnummer();

    String getId();
    void setId();




    }
