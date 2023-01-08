package webservice.irina.task3.repo;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Ladokdata;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@Repository


public interface LadokRepo extends JpaRepository<Ladokdata, Long> {

    @NotNull



    List <Ladokdata> findPnrByStudentnamn (String studentnamn);

    void deleteLadokdataById(@NotNull Long id);


    List<Ladokdata> getLadokdataById(Long personnummer);

   // Optional<Ladokdata> findLadokdataById(Long id);

    @Transactional
    @Modifying
    @Query(value="update ladokdata l set l.resultat=?5, l.registr_datum=?2, l.status=?3, l.information=?4 where l.id=?1", nativeQuery = true)
    Integer updateResult(@Param("id") Long id, @Param ("registr_datum") @DateTimeFormat(pattern= "yyyy-MM-dd")  Date registr_datum, @Param ("status") String status,
                                           @Param ("information") String information, @Param ("resultat") String resultat);


}
