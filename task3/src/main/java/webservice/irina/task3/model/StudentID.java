/**package webservice.irina.task3.model;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable

public class StudentID implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "studentID", referencedColumnName = "studentid", nullable = false)
    private Canvasdata canvasdata;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "studentID", referencedColumnName = "studentid", nullable = false)
    private StudentIts studentIts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Canvasdata getCanvasdata() {
        return canvasdata;
    }

    public void setCanvasdata(Canvasdata canvasdata) {
        this.canvasdata = canvasdata;
    }

    public StudentIts getStudentIts() {
        return studentIts;
    }

    public void setStudentIts(StudentIts studentIts) {
        this.studentIts = studentIts;
    }
}
**/