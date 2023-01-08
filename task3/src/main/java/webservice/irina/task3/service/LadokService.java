package webservice.irina.task3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Ladokdata;
import webservice.irina.task3.repo.LadokRepo;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")

@Service("Ladokdataservice")

public class LadokService {

    private final LadokRepo ladokRepo;



    @Autowired
    public LadokService(LadokRepo ladokRepo) {
        this.ladokRepo = ladokRepo;
    }

    public List<Ladokdata> getLadokdata(Long id) {
        return ladokRepo.getLadokdataById(id);
    }

    public List<Ladokdata> findAllLadokdata()
    {return ladokRepo.findAll();}

    public List<Ladokdata> getPersonnummer(Long personnummer) {
        return ladokRepo.getLadokdataById(personnummer);
    }


    public Ladokdata updateResult(Ladokdata ladokdata)
    {return ladokRepo.save(ladokdata);}


    public Ladokdata saveLadokdata(Ladokdata ld, Long id) {
        Optional<Ladokdata> optionalLadokdata = ladokRepo.findById(ld.getId());
        Ladokdata _ld = new Ladokdata();
        if (optionalLadokdata.isPresent()) {
            _ld.setId(ld.getId());
            _ld.setResultat(ld.getResultat());
            _ld.setInformation(ld.getInformation());
            _ld.setStatus(ld.getStatus());
          //  _ld.setRegistr_datum(ld.getRegistr_datum());
            return _ld;
        }


        return null;
    }
}
