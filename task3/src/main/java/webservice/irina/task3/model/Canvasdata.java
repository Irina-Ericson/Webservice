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

    private Long c_id;

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
    private String uppgift;
    @Column(name="omdome")
    private String omdome;
    private String kommentar;

    @OneToOne
   @JoinColumn(name="stud_id")
    private StudentIts studentIts;

    @OneToOne
    @JoinColumn(name="stud_r_id")
    private Ladokdata ladokdata;

    public Ladokdata getLadokdata() {
        return ladokdata;
    }

    public void setLadokdata(Ladokdata ladokdata) {
        this.ladokdata = ladokdata;
    }

    public StudentIts getStudentIts() {
        return studentIts;
    }

    public void setStudentIts(StudentIts studentIts) {
        this.studentIts = studentIts;
    }




    public Canvasdata(Long c_id, String studentID, String studentnamn, String epostadress, String kursnamn,
                      String kurskod, String termin, int lasperiod, byte[] dokument, String lank,
                      String uppgift, String omdome, String kommentar, StudentIts studentIts){
        this.c_id=c_id;
        this.studentID=studentID;
        this.studentnamn=studentnamn;
        this.epostadress=epostadress;
        this.kursnamn=kursnamn;
        this.kurskod=kurskod;
        this.termin=termin;
        this.lasperiod=lasperiod;
        this.dokument=dokument;
        this.lank=lank;
        this.uppgift=uppgift;
        this.omdome=omdome;
        this.kommentar=kommentar;
        this.studentIts=studentIts;


    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
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

    public String getUppgift() {
        return uppgift;
    }

    public String getOmdome() {
        return omdome;
    }

    public void setOmdome(String omdome) {
        this.omdome = omdome;
    }

    public void setUppgift(String uppgift) {
        this.uppgift = uppgift;
    }


    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }


}
