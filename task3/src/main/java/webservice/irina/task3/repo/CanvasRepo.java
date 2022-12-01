package webservice.irina.task3.repo;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import webservice.irina.task3.dto.CanvasdataResponse;
import webservice.irina.task3.model.CanvasProjection;
import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Canvasdata;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@Repository


public interface CanvasRepo extends JpaRepository<Canvasdata, Long> {

    @NotNull
   //Optional<Canvasdata> findCanvasdataById(Long id);

  //  List<Canvasdata> getCanvasdataById(Long id);



   // void deleteCanvasdataById(@NotNull Long id);

  //  @Query(value="Select * from canvasdata", nativeQuery = true)
    @Query(value="select c.*, s.* from canvasdata c, studentits s where c.studentid LIKE s.student_id", nativeQuery = true)
    List <CanvasProjection> findAllData();

    @Query(value="select * from canvasdata c inner join studentits s on c.studentid=s.student_id inner join ladokdata l on s.personnummer=l.pnr group by uppgift", nativeQuery = true)
    List <CanvasResultProjection> findAllResultData();


    @Query(value="select * from canvasdata c inner join studentits s on c.studentid=s.student_id inner join ladokdata l on s.personnummer=l.pnr group by uppgift", nativeQuery = true)

    List <CanvasResultProjection> findAllResultDataByKursnamn(String kursnamn);

    List <Canvasdata> findStudentByStudentID(String studentID);

    List <Canvasdata> findStudentByKurskod(String kurskod);

    @Query("SELECT u.studentnamn FROM Canvasdata u")
    List<Canvasdata[]> getJoinInformation();
}

