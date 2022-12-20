package webservice.irina.task3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservice.irina.task3.exception.ResourceNotFoundException;
import webservice.irina.task3.model.Ladokdata;
import webservice.irina.task3.repo.LadokRepo;
import webservice.irina.task3.service.LadokService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/ladokdata")
@RestController

public class LadokController {

    @Autowired
    public LadokService ladokService;

    @Autowired
    public LadokRepo ladokRepo;

    private final Logger debugLogger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @GetMapping("/ladokdata")
    public List<Ladokdata> getAllLadokdataById(String id) {
        return ladokRepo.findAll();
    }


    @PostMapping("/ladokdata")
    public Ladokdata createLadokdata(@RequestBody Ladokdata ld) {
        return ladokRepo.save(ld);
    }

    @GetMapping("/ladokdata/{id}")
    public ResponseEntity<Ladokdata> getLadokdataById(@PathVariable Long id) {
        Ladokdata ld = ladokRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ladokdata finns inte med id :" + id));
        return ResponseEntity.ok(ld);
    }

    @GetMapping("/myLadokdata/{studentnamn}")
    public List findPnrByStudentnamn(@PathVariable("studentnamn") String studentnamn) {

        List student = ladokRepo.findPnrByStudentnamn(studentnamn);
        return student;
    }

    @PutMapping("/saveLadokdata/{id}")
    @ResponseBody
    Ladokdata saveLadokdata(@PathVariable("id") Long id, @RequestBody Ladokdata ld) {
        return ladokRepo.findLadokdataById(id)
                .map(_ld -> {

                    _ld.setId(ld.getId());
                    _ld.setStudentnamn(ld.getStudentnamn());
                    _ld.setAntagningsar(ld.getAntagningsar());
                    _ld.setPersonnummer(ld.getPersonnummer());
                    _ld.setKursnummer(ld.getKursnummer());
                    _ld.setKursar(ld.getKursar());
                    _ld.setResultat(ld.getResultat());
                    _ld.setIntyg(ld.getIntyg());
                    _ld.setCampus(ld.isCampus());
                    _ld.setRegistrDatum(ld.getRegistrDatum());
                    _ld.setInformation(ld.getInformation());
                    _ld.setKursmodul(ld.getKursmodul());
                    return ladokRepo.save(_ld);
                })
                .orElseGet(() -> {
                    return ladokRepo.save(ld);

                });

    }
}