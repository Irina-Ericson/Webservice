package webservice.irina.task3.repo;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import webservice.irina.task3.model.Epok;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@Repository


public interface EpokRepo extends JpaRepository<Epok, Long> {

    @NotNull
    Optional<Epok> findKursById(Long id);

    List<Epok> getKursById(Long id);

    List<Epok> findKursByKurskod(String kurskod);

    void deleteKursById(@NotNull Long id);
}
