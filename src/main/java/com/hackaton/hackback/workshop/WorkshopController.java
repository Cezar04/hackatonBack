package com.hackaton.hackback.workshop;

import com.hackaton.hackback.workshop.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/workshop")
public class WorkshopController {
    private WorkshopService workshopService;

    @Autowired
    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping("/all-workshops")
    public List<WorkshopDAO> getAllWorkshops(){
        return workshopService.findAll();
    }

    @PostMapping("/add-workshop")
    private ResponseEntity<?> addWorkshop(@RequestBody WorkshopDAO workshopDAO){
        return workshopService.addWorkshop(workshopDAO);
    }
}
