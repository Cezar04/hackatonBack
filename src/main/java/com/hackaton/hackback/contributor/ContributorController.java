package com.hackaton.hackback.contributor;

import com.hackaton.hackback.contributor.service.ContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/contributor")
public class ContributorController {
    private ContributorService contributorService;

    @Autowired
    public ContributorController(ContributorService contributorService) {
        this.contributorService = contributorService;
    }

    @GetMapping("/all")
    public List<ContributorModel> getAllContributor(){
        return contributorService.findAll();
    }

    @GetMapping("/{contributorId}")
    public ResponseEntity<?> getContributor(@PathVariable UUID contributorId){
        return contributorService.findByContributorId(contributorId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addContributor(@RequestBody ContributorDAO contributorDAO){
        return contributorService.addContributor(contributorDAO);
    }

    @DeleteMapping("/delete/{contributorId}")
    public ResponseEntity<?> deleteContributor(@PathVariable UUID contributorId){
        return contributorService.deleteContributor(contributorId);
    }
}
