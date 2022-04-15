package com.hackaton.hackback.workshopForm;

import com.hackaton.hackback.workshopForm.service.WorkshopFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/workshop-form")
public class WorkshopFormController {
    private WorkshopFormService workshopFormService;

    @Autowired
    public WorkshopFormController(WorkshopFormService workshopFormService) {
        this.workshopFormService = workshopFormService;
    }


    @GetMapping("/all")
    public List<WorkshopFormModel> getAllForms(){
        return workshopFormService.findAll();
    }

    @GetMapping("/{workshopId}")
    public ResponseEntity<?> getForm(@PathVariable UUID workshopId){
        return workshopFormService.findWorkshopForm(workshopId);
    }

    @PostMapping("/add/{workshopId}")
    public ResponseEntity<?> addForm(@RequestBody WorkshopFormDAO workshopFormDAO, @PathVariable UUID workshopId){
        return workshopFormService.addWorkshopForm(workshopFormDAO,workshopId);
    }


}
