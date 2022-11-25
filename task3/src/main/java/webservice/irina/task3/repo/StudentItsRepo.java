package webservice.irina.task3.repo;


import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import webservice.irina.task3.dto.CanvasdataResponse;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.model.StudentIts;
import webservice.irina.task3.model.StudentItsProjection;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@EnableJpaRepositories
@Transactional

public interface StudentItsRepo extends JpaRepository<StudentIts, Long> {


    @Query(value="Select * from studentits", nativeQuery = true)
    List<StudentItsProjection> findAllData();

    List<StudentIts> getPnrByStudentID(String studentID);


    Optional<StudentIts> findById(Long id);


    StudentIts save(StudentIts st);

    Optional<StudentIts> findStudentById(Long id);




}
