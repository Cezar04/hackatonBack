package com.hackaton.hackback.contributor.service;

import com.hackaton.hackback.contributor.ContributorDAO;
import com.hackaton.hackback.contributor.ContributorModel;
import com.hackaton.hackback.contributor.ContributorRepository;
import com.hackaton.hackback.helper.ServiceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ContributorServiceImpl implements ContributorService{
    private ContributorRepository contributorRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public ContributorServiceImpl(ContributorRepository contributorRepository, ServiceHelper serviceHelper) {
        this.contributorRepository = contributorRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<ContributorModel> findAll() {
        return contributorRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addContributor(ContributorDAO contributorDAO) {
        ContributorModel contributor = serviceHelper.convertToContributorEntity(contributorDAO);
        contributorRepository.save(contributor);
        return new ResponseEntity<>(contributor, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByContributorId(UUID contributorId) {
        ContributorModel contributorModel = contributorRepository.getById(contributorId);
        ContributorDAO contributor = serviceHelper.convertToContributorDAO(contributorModel);
        return new ResponseEntity<>(contributor,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteContributor(UUID contributorId) {
        Optional<ContributorModel> contributorModelOptional =contributorRepository.findById(contributorId);
        if(contributorModelOptional.isPresent()){
            ContributorModel contributor = contributorModelOptional.get();
            contributorRepository.delete(contributor);

            return new ResponseEntity<>(contributor,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("no record found to delete!", HttpStatus.NOT_FOUND);
        }

    }
}
