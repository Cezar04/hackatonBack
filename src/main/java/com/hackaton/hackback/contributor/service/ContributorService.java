package com.hackaton.hackback.contributor.service;

import com.hackaton.hackback.contributor.ContributorDAO;
import com.hackaton.hackback.contributor.ContributorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ContributorService {
    List<ContributorModel>findAll();
    ResponseEntity<?> addContributor(ContributorDAO contributorDAO);
    ResponseEntity<?> findByContributorId(UUID contributorId);
    ResponseEntity<?> deleteContributor(UUID contributorId);
}
