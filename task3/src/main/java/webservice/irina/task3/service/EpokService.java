package webservice.irina.task3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import webservice.irina.task3.model.Epok;

import webservice.irina.task3.repo.EpokRepo;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@Service("EpokService")

public class EpokService {
    private final EpokRepo epokRepo;



    @Autowired
    public EpokService(EpokRepo epokRepo) {
        this.epokRepo = epokRepo;
    }

    public List<Epok> getKursnummer(Long id) {
        return epokRepo.getKursById(id);
    }

    public List<Epok> findAllKurs()
    {return epokRepo.findAll();}




}
