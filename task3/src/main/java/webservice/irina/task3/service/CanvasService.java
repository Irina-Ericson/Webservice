package webservice.irina.task3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import webservice.irina.task3.model.CanvasProjection;
import webservice.irina.task3.model.CanvasResultProjection;
import webservice.irina.task3.model.Canvasdata;
import webservice.irina.task3.repo.CanvasRepo;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@Service("CanvasdataService")

public class CanvasService {

    @Autowired
    private CanvasRepo canvasRepo;



    @Autowired
    public CanvasService(CanvasRepo canvasRepo) {
        this.canvasRepo = canvasRepo;
    }


    public List<CanvasProjection> findAllData(){

        return canvasRepo.findAllData();
    }

    public List<CanvasResultProjection> findAllResultData(){

        return canvasRepo.findAllResultData();
    }









}
