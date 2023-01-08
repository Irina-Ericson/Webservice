package webservice.irina.task3.repo;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import webservice.irina.task3.model.CanvasProjection;
import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.model.Ladokdata;


import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@Repository


public interface CanvasRepo extends JpaRepository<Canvasdata, Long> {

    @NotNull
 //  Optional<Canvasdata> findCanvasdataByC_id(Long c_id);

  //  List<Canvasdata> getCanvasdataById(Long id);

    List<CanvasResultProjection> findUppgiftByKursnamn(String kursnamn);

   // void deleteCanvasdataById(@NotNull Long id);

  //  @Query(value="Select * from canvasdata", nativeQuery = true)
    @Query(value="select c.*, s.* from canvasdata c, studentits s where c.studentid LIKE s.student_id", nativeQuery = true)
    List <CanvasProjection> findAllData();

   @Query(value="select * from canvasdata c inner join studentits s on c.studentid=s.student_id inner join ladokdata l on s.personnummer=l.pnr group by uppgift", nativeQuery = true)
    List <CanvasResultProjection> findAllResultData();


   @Query(value="select * from canvasdata c inner join studentits s on c.studentid=s.student_id inner join ladokdata l on s.personnummer=l.pnr", nativeQuery = true)

    List <CanvasResultProjection> findAllResultDataByKursnamn(String kursnamn);

   //@Query(value="select * from canvasdata c inner join studentits s on c.studentid LIKE s.student_id inner join ladokdata l on s.personnummer LIKE l.pnr where c.kursnamn=?1 and c.uppgift=?2 group by c.uppgift", nativeQuery = true)
   @Query(value="select * from canvasdata c inner join studentits s on c.studentid LIKE s.student_id inner join ladokdata l on " +
           "s.personnummer LIKE l.pnr inner join epok e on e.kurs LIKE c.kursnamn where c.kursnamn=?1 and c.uppgift=?2 and c.uppgift=l.kursmodul group by l.id", nativeQuery = true)

    List <CanvasResultProjection> findResultDataByUppgift(@Param ("kursnamn") String kursnamn, @Param("uppgift")String uppgift);

    List <Canvasdata> findStudentByStudentID(String studentID);

    List <Canvasdata> findStudentByKurskod(String kurskod);


    @Query("SELECT u.studentnamn FROM Canvasdata u")
    List<Canvasdata[]> getJoinInformation();


}

