package webservice.irina.task3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservice.irina.task3.exception.ResourceNotFoundException;
import webservice.irina.task3.model.Epok;
import webservice.irina.task3.repo.EpokRepo;
import webservice.irina.task3.service.EpokService;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/kurs", produces="application/json")
@RestController
public class EpokController {

    @Autowired
    public EpokService epokService;

    @Autowired
    public EpokRepo kursRepo;

    private final Logger debugLogger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @GetMapping("/kurs")
    public List<Epok> getAllKursById(String id) {
        return kursRepo.findAll();
    }


    @PostMapping("/kurs")
    public Epok createKurs(@RequestBody Epok k) {
        return kursRepo.save(k);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Epok> getKursById(@PathVariable Long id) {
        Epok k = kursRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Kurs finns inte med id :" + id));
        return ResponseEntity.ok(k);
    }

    @GetMapping("myKurs/{kurskod}")
    public List findKursByKurskod(@PathVariable ("kurskod") String kurskod) {
        List k = kursRepo.findKursByKurskod(kurskod);

        return k;
    }

    @PutMapping(value = "/saveKurs")
    @ResponseBody
    ResponseEntity<Epok> saveKurs(@PathVariable("id") Long id, @RequestBody Epok k) {
        Optional<Epok> kursOptional = kursRepo.findKursById(id);

        if (kursOptional.isPresent()) {
            Epok _k = kursOptional.get();
            _k.setKurskod(k.getKurskod());
            _k.setModulKod(k.getModulKod());
            _k.setModulBenamning(k.getModulBenamning());
            return new ResponseEntity<>(kursRepo.save(_k), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}