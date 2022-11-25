package webservice.irina.task3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Entity
@Table(name="studentits")
@NoArgsConstructor
public class StudentIts implements Serializable {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;
    @Column(name="s_namn")
    private String studentnamn;
   // private String personnummer;
    @Id
    @Column(name = "student_id", nullable=false)
    private String studentID;
    private String losenord;
    private String epostadress;
    private String personnummer;
    @OneToOne (mappedBy = "studentIts")
    private Canvasdata canvasdata;

    public Canvasdata getCanvasdata() {
        return canvasdata;
    }

    public void setCanvasdata(Canvasdata canvasdata) {
        this.canvasdata = canvasdata;
    }

    public StudentIts(Long id, String studentnamn, String personnummer, String studentID, String losenord, String epostadress){

        this.id=id;
        this.studentnamn=studentnamn;
        this.personnummer=personnummer;
        this.studentID=studentID;
        this.losenord=losenord;
        this.epostadress=epostadress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentnamn() {
        return studentnamn;
    }

    public void setStudentnamn(String studentnamn) {
        this.studentnamn = studentnamn;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getLosenord() {
        return losenord;
    }

    public void setLosenord(String losenord) {
        this.losenord = losenord;
    }

    public String getEpostadress() {
        return epostadress;
    }

    public void setEpostadress(String epostadress) {
        this.epostadress = epostadress;
    }


}
