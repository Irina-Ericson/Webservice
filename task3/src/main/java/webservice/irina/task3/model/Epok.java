package webservice.irina.task3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Epok implements Serializable {
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    public Long getId() {
        return id;
    }
    private String kurskod;
    private String modulKod;
    private String modulBenamning;

    public Epok(){}

    public Epok(Long id, String kurskod, String modulKod, String modulBenamning){

        this.id=id;
        this.kurskod=kurskod;
        this.modulKod=modulKod;
        this.modulBenamning=modulBenamning;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKurskod() {
        return kurskod;
    }

    public void setKurskod(String kurskod) {
        this.kurskod = kurskod;
    }

    public String getModulKod() {
        return modulKod;
    }

    public void setModulKod(String modulKod) {
        this.modulKod = modulKod;
    }

    public String getModulBenamning() {
        return modulBenamning;
    }

    public void setModulBenamning(String modulBenamning) {
        this.modulBenamning = modulBenamning;
    }


}
