package webservice.irina.task3.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import webservice.irina.task3.exception.ResourceNotFoundException;
import webservice.irina.task3.model.CanvasProjection;
import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.model.Ladokdata;
import webservice.irina.task3.repo.CanvasRepo;
import webservice.irina.task3.repo.LadokRepo;
import webservice.irina.task3.service.CanvasService;


import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/canvasdata")
@RestController


public class CanvasController {
    @Autowired
    public CanvasService canvasService;



    @Autowired
    public CanvasRepo canvasRepo;
    public LadokRepo ladokRepo;

    private final Logger debugLogger = LoggerFactory.getLogger(this.getClass().getCanonicalName());

    @GetMapping("/canvasdata")
    List<CanvasProjection> getAllCanvasdataById(){
        return canvasService.findAllData();
    }

 /**   @GetMapping("/canvasdataResult")
    List<CanvasResultProjection> getAllResultCanvasdataById(){
        return canvasService.findAllResultData();
    }**/

    @PostMapping("/canvasdata")
    public Canvasdata createCanvasdata(@RequestBody Canvasdata cd) {
        return canvasRepo.save(cd);
    }

 /**   @GetMapping("/canvasdata/{c_id}")
    public ResponseEntity<Canvasdata> getCanvasdataById(@PathVariable Long c_id) {
        Canvasdata cd = canvasRepo.findById(c_id)
                .orElseThrow(() -> new ResourceNotFoundException("Canvasdata finns inte med id :" + c_id));
        return ResponseEntity.ok(cd);
    }**/

    @GetMapping("/canvasdataResult/{kursnamn}")
    List<CanvasResultProjection> findAllResultDataByKursnamn (@PathVariable String kursnamn) {
        return canvasService.findAllResultDataByKursnamn(kursnamn);
    }

    @GetMapping(path="/canvasdataResult_2")
    @ResponseBody
    List<CanvasResultProjection> findResultDataByUppgift (@RequestParam("kursnamn") String kursnamn, @RequestParam("uppgift") String uppgift) {

        return canvasService.findResultDataByUppgift(kursnamn, uppgift);
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

    @ControllerAdvice
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public class ControllerExceptionHandler {

        @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ResponseBody
        public Map<String, String> handleServiceCallException(MethodArgumentTypeMismatchException e) {
            Map<String, String> errMessages = new HashMap<>();
            errMessages.put("error", "MethodArgumentTypeMismatchException");
            errMessages.put("message", e.getMessage());
            errMessages.put("parameter", e.getName());
            errMessages.put("errorCode", e.getErrorCode());
            return errMessages;
        }

    }


   /** @PutMapping(value="/saveCanvasdata/{id}")
    @ResponseBody
    public ResponseEntity<CanvasResultProjection> saveCanvasdata(@PathVariable("id") Long id, @RequestBody CanvasResultProjection crp) {
        Optional<Ladokdata> ladokdata=ladokRepo.findById(id);



            Ladokdata _crp =  ladokdata.get();
            _crp.setResultat(crp.getResultat());
            _crp.setRegistrDatum(crp.getRegistrDatum());
            _crp.setStatus(crp.getStatus());
            _crp.setInformation(crp.getInformation());

            return new ResponseEntity<CanvasResultProjection>((CanvasResultProjection) ladokRepo.save(_crp), HttpStatus.OK);}

    }**/

}
