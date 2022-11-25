package webservice.irina.task3.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.ToString;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data


@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)


public class CanvasdataResponse {



        private String studentnamn;

        public CanvasdataResponse (String studentnamn){
            this.studentnamn=studentnamn;
        }
       // private String personnummer;

    public String getStudentnamn() {
        return studentnamn;
    }

    public void setStudentnamn(String studentnamn) {
        this.studentnamn = studentnamn;
    }

  /**  public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }**/
}

