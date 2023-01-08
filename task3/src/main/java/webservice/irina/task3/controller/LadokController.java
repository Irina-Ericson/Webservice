package webservice.irina.task3.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import webservice.irina.task3.exception.ResourceNotFoundException;
import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Ladokdata;
import webservice.irina.task3.repo.LadokRepo;
import webservice.irina.task3.service.LadokService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/ladokdata")
@RestController
@EnableWebMvc
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
        return ok(ld);
    }

    @GetMapping("/myLadokdata/{studentnamn}")
    public List findPnrByStudentnamn(@PathVariable("studentnamn") String studentnamn) {

        List student = ladokRepo.findPnrByStudentnamn(studentnamn);
        return student;
    }

   /**
    * @PutMapping(value="/updateCanvasResult/{id}")
    * @ResponseBody void updateResult(@PathVariable ("id") Long id, @Param("registrDatum") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date registrDatum,
    * @Param (" status ") String status, @Param ("information") String information,
    * @Param (" resultat ") String resultat){
    * //List<CanvasResultProjection> cdOptional=canvasRepo.updateResult(resultat,registrDatum,status, information, id);
    * <p>
    * this.ladokRepo.updateResult(id, registrDatum, status, information,resultat);
    * <p>
    * }
    **/


    @PatchMapping(path="/saveLadokdata/{id}/{resultat}/{registr_datum}/{status}/{information}")


   /** public void saveLadokdata(@PathVariable("id") Long id, @RequestBody Ladokdata ld){
        ladokRepo.save(ld);
    }**/
   public ResponseEntity <CanvasResultProjection> saveLadokdata(@PathVariable Long id, @RequestParam (name="registr_datum", required = false)
                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date registr_datum,
                                                                @PathVariable String status, @PathVariable String information,
                                                                @PathVariable String resultat) {
   /**public Ladokdata saveLadokdata (@RequestBody Ladokdata ld, @PathVariable("id") Long id) {**/

        return new ResponseEntity(ladokRepo.updateResult(id, registr_datum, status, information, resultat), HttpStatus.OK);
        /**return ladokService.saveLadokdata(ld, id);**/
    }

    @Component
    public class DateUtilToDateSQLConverter implements Converter<java.util.Date, Date> {

        @Override
        public Date convert(java.util.Date source) {
            return new Date(source.getTime());
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }

}