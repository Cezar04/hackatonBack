package com.hackaton.hackback.workshop;

import com.hackaton.hackback.workshop.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{workshopId}")
    public ResponseEntity<?> getWorkshop(@PathVariable UUID workshopId){
        return workshopService.findWorkshopById(workshopId);
    }

    @DeleteMapping("/delete/{workshopId}")
    public ResponseEntity<?> deleteWorkshop(@PathVariable UUID workshopId){
        return workshopService.deleteWorkshop(workshopId);
    }

    @PostMapping("/add-workshop")
    private ResponseEntity<?> addWorkshop(@RequestBody WorkshopDAO workshopDAO){
        return workshopService.addWorkshop(workshopDAO);
    }


}
