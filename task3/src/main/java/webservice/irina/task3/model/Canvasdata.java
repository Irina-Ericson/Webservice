package webservice.irina.task3.model;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.web.servlet.View;
import webservice.irina.task3.dto.CanvasdataResponse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="canvasdata")
@NoArgsConstructor

public class Canvasdata implements Serializable {

    @Id
    @Column(name="c_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

   @Column(name = "studentid", insertable = false, updatable = false)

    private String studentID;

    private String studentnamn;
    @Column(name = "email")
    private String epostadress;
    private String kursnamn;

    private String kurskod;
    private String termin;
    private int lasperiod;
    private byte[] dokument;
    private String lank;

    @Column(name = "uppgift")
    private String inlamningsuppgift;
    private String betyg;
    private String kommentar;

    @OneToOne
   @JoinColumn(name="stud_id", referencedColumnName = "id")
    private StudentIts studentIts;

    public StudentIts getStudentIts() {
        return studentIts;
    }

    public void setStudentIts(StudentIts studentIts) {
        this.studentIts = studentIts;
    }




    public Canvasdata(Long id, String studentID, String studentnamn, String epostadress, String kursnamn,
                      String kurskod, String termin, int lasperiod, byte[] dokument, String lank,
                      String inlamningsuppgift, String betyg, String kommentar, StudentIts studentIts){
        this.id=id;
        this.studentID=studentID;
        this.studentnamn=studentnamn;
        this.epostadress=epostadress;
        this.kursnamn=kursnamn;
        this.kurskod=kurskod;
        this.termin=termin;
        this.lasperiod=lasperiod;
        this.dokument=dokument;
        this.lank=lank;
        this.inlamningsuppgift=inlamningsuppgift;
        this.betyg=betyg;
        this.kommentar=kommentar;
        this.studentIts=studentIts;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentnamn() {
        return studentnamn;
    }

    public void setStudentnamn(String studentnamn) {
        this.studentnamn = studentnamn;
    }

    public String getEpostadress() {
        return epostadress;
    }

    public void setEpostadress(String epostadress) {
        this.epostadress = epostadress;
    }

    public String getKursnamn() {
        return kursnamn;
    }

    public void setKursnamn(String kursnamn) {
        this.kursnamn = kursnamn;
    }

    public String getKurskod() {
        return kurskod;
    }

    public void setKurskod(String kurskod) {
        this.kurskod = kurskod;
    }

    public String getTermin() {
        return termin;
    }

    public void setTermin(String termin) {
        this.termin = termin;
    }

    public int getLasperiod() {
        return lasperiod;
    }

    public void setLasperiod(int lasperiod) {
        this.lasperiod = lasperiod;
    }

    public byte[] getDokument() {
        return dokument;
    }

    public void setDokument(byte[] dokument) {
        this.dokument = dokument;
    }

    public String getLank() {
        return lank;
    }

    public void setLank(String lank) {
        this.lank = lank;
    }

    public String getInlamningsuppgift() {
        return inlamningsuppgift;
    }

    public void setInlamningsuppgift(String inlamningsuppgift) {
        this.inlamningsuppgift = inlamningsuppgift;
    }

    public String getBetyg() {
        return betyg;
    }

    public void setBetyg(String betyg) {
        this.betyg = betyg;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }


}
