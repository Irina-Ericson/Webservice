package webservice.irina.task3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Ladokdata implements Serializable {
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentnamn;
    private Long antagningsar;
    private String personnummer;
    private String kursnummer;
    private Long kursar;
    private String resultat;
    private byte[] intyg;
    private boolean campus;

    public Ladokdata() {
    }

    public Ladokdata(Long id, String studentnamn, Long antagningsar, String personnummer, String kursnummer,
                     Long kursar, String resultat, byte[] intyg, boolean campus) {
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

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

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


}
