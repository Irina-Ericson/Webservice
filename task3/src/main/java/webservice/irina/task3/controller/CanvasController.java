package webservice.irina.task3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webservice.irina.task3.exception.ResourceNotFoundException;
import webservice.irina.task3.model.CanvasProjection;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.repo.CanvasRepo;
import webservice.irina.task3.service.CanvasService;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/canvasdata")
@RestController


public class CanvasController {
    @Autowired
    public CanvasService canvasService;



    @Autowired
    public CanvasRepo canvasRepo;

    private final Logger debugLogger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @GetMapping("/canvasdata")
    List<CanvasProjection> getAllCanvasdataById(){
        return canvasService.findAllData();
    }


    @PostMapping("/canvasdata")
    public Canvasdata createCanvasdata(@RequestBody Canvasdata cd) {
        return canvasRepo.save(cd);
    }

    @GetMapping("/canvasdata/{id}")
    public ResponseEntity<Canvasdata> getCanvasdataById(@PathVariable Long id) {
        Canvasdata cd = canvasRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Canvasdata finns inte med id :" + id));
        return ResponseEntity.ok(cd);
    }

   /** @GetMapping("/myCanvasdata_1/{studentID}")
    public List <Canvasdata> getStudentByStudentID (@PathVariable String studentID) {

        List student = canvasRepo.findStudentByStudentID(studentID);
        List <CanvasdataResponse> canvasdataResponse=new ArrayList<CanvasdataResponse>();
        student.stream().forEach(st->{
            canvasdataResponse.add(new CanvasdataResponse(st));
        });
        return canvasdataResponse;
    }**/



    @GetMapping("/myCanvasdata_2/{kurskod}")
    public List getStudentByKurskod (@PathVariable("kurskod") String kurskod) {

        List student = canvasRepo.findStudentByKurskod(kurskod);
        return student;
    }



    @PutMapping(value="/saveCanvasdata")
    @ResponseBody
    ResponseEntity<Canvasdata> saveCanvasdata(@PathVariable("id") Long id, @RequestBody Canvasdata cd) {
        Optional<Canvasdata> canvasdatadataOptional = canvasRepo.findCanvasdataById(id);

        if (canvasdatadataOptional.isPresent()) {
            Canvasdata _cd = canvasdatadataOptional.get();
            _cd.setStudentID(cd.getStudentID());
            _cd.setStudentnamn(cd.getStudentnamn());
            _cd.setEpostadress(cd.getEpostadress());
            _cd.setKursnamn(cd.getKursnamn());
            _cd.setKurskod(cd.getKurskod());
            _cd.setTermin(cd.getTermin());
            _cd.setLasperiod(cd.getLasperiod());
            _cd.setDokument(cd.getDokument());
            _cd.setLank(cd.getLank());
            _cd.setInlamningsuppgift(cd.getInlamningsuppgift());
            _cd.setBetyg(cd.getBetyg());
            _cd.setKommentar(cd.getKommentar());
            return new ResponseEntity<>(canvasRepo.save(_cd), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
