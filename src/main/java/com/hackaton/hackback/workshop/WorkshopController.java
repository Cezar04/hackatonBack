package com.hackaton.hackback.workshop;

import com.hackaton.hackback.workshop.service.WorkshopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/workshop")
@Slf4j
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

    @PostMapping(value = "/add-workshop",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    private ResponseEntity<?> addWorkshop(@RequestPart("image") MultipartFile file,
                                          @RequestPart("workshop") String workshop) throws IOException {

        return workshopService.addWorkshop(file, workshop);

    }


}
