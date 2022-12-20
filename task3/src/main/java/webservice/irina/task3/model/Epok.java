package webservice.irina.task3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Epok implements Serializable {
    @Id
    @Column(name="ide", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public Long getId() {
        return id;
    }
    private String kurs;

    private String modul;


    public Epok(){}

    public Epok(Long id, String kurs, String modul){

        this.id=id;
        this.kurs=kurs;
        this.modul=modul;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public String getModul() {
        return modul;
    }

    public void setModul(String modul) {
        this.modul = modul;
    }



}
