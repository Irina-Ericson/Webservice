package webservice.irina.task3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Ladokdata implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @JsonFormat(shape=JsonFormat.Shape.STRING)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="stud_namn")
    private String studentnamn;
    private Long antagningsar;
    @Column(name="pnr")
    private String personnummer;
    private String kursnummer;
    private Long kursar;
    private String resultat;
    private byte[] intyg;
    private boolean campus;

    public String getKursmodul() {
        return kursmodul;
    }

    public void setKursmodul(String kursmodul) {
        this.kursmodul = kursmodul;
    }

    private String kursmodul;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    private String information;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
    private Date registr_datum;

    public Date getRegistr_datum() {
        return registr_datum;
    }

    public void setRegistr_datum(String registr_datum) {
        try {
            this.registr_datum = new SimpleDateFormat("yyyy-MM-dd").parse(registr_datum);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Canvasdata getCanvasdata() {
        return canvasdata;
    }

    public void setCanvasdata(Canvasdata canvasdata) {
        this.canvasdata = canvasdata;
    }

    @OneToOne (mappedBy = "ladokdata")
    private Canvasdata canvasdata;

    public Ladokdata() {
    }

    public Ladokdata(Long id, String studentnamn, Long antagningsar, String personnummer, String kursnummer,
                     Long kursar, String resultat, byte[] intyg, boolean campus, Date registr_datum, String information, String kursmodul) {
        super();
        this.id = id;
        this.studentnamn = studentnamn;
        this.antagningsar = antagningsar;
        this.personnummer = personnummer;
        this.kursnummer = kursnummer;
        this.kursar=kursar;
        this.resultat=resultat;
        this.intyg=intyg;
        this.campus=campus;
        this.registr_datum=registr_datum;
        this.information=information;
        this.kursmodul=kursmodul;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;


    public String getStudentnamn() {
        return studentnamn;
    }

    public void setStudentnamn(String studentnamn) {
        this.studentnamn = studentnamn;
    }

    public Long getAntagningsar() {
        return antagningsar;
    }

    public void setAntagningsar(Long antagningsar) {
        this.antagningsar = antagningsar;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public String getKursnummer() {
        return kursnummer;
    }

    public void setKursnummer(String kursnummer) {
        this.kursnummer = kursnummer;
    }

    public Long getKursar() {
        return kursar;
    }

    public void setKursar(Long kursar) {
        this.kursar = kursar;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public byte[] getIntyg() {
        return intyg;
    }

    public void setIntyg(byte[] intyg) {
        this.intyg = intyg;
    }

    public boolean isCampus() {
        return campus;
    }

    public void setCampus(boolean campus) {
        this.campus = campus;
    }

  /**  @Override
    public String toString() {
        return "Ladokdata{" +
                "id=" + id +
                ", kursar='" + kursar + '\'' +
                ", resultat='" + resultat + '\'' +
                ", intyg='" + intyg + '\'' +

                '}';

    }**/

    }
