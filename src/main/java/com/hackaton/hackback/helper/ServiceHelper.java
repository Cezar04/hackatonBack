package com.hackaton.hackback.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.hackback.contributor.ContributorDAO;
import com.hackaton.hackback.contributor.ContributorModel;
import com.hackaton.hackback.workshop.WorkshopDAO;
import com.hackaton.hackback.workshop.WorkshopModel;

import com.hackaton.hackback.workshopForm.WorkshopFormDAO;
import com.hackaton.hackback.workshopForm.WorkshopFormModel;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ServiceHelper {
    public WorkshopDAO convertToWorkshopDAO(WorkshopModel workshopModel){
        return WorkshopDAO.builder()
                .id(workshopModel.getId())
                .Title(workshopModel.getTitle())
                .subTitle(workshopModel.getSubTitle())
                .description(workshopModel.getDescription())
                .startDate(workshopModel.getStartDate())
                .image(workshopModel.getImage())
                .endDate(workshopModel.getEndDate())
                .build();
    }

    public WorkshopModel convertToWorkshopEntity(WorkshopDAO workshopDAO){
        return WorkshopModel.builder()
                .Title(workshopDAO.getTitle())
                .subTitle(workshopDAO.getSubTitle())
                .description(workshopDAO.getDescription())
                .image(workshopDAO.getImage())
                .startDate(workshopDAO.getStartDate())
                .endDate(workshopDAO.getEndDate())
                .build();
    }

    public WorkshopFormDAO convertToWorkshopFormDAO(WorkshopFormModel workshopFormModel){
        return WorkshopFormDAO.builder()
                .id(workshopFormModel.getId())
                .firstName(workshopFormModel.getFirstName())
                .lastName(workshopFormModel.getLastName())
                .city(workshopFormModel.getCity())
                .email(workshopFormModel.getEmail())
                .phoneNumber(workshopFormModel.getPhoneNumber())
                .build();
    }
    public WorkshopFormModel convertToWorkshopFormEntity(WorkshopFormDAO workshopFormDAO){
        return WorkshopFormModel.builder()
                .firstName(workshopFormDAO.getFirstName())
                .lastName(workshopFormDAO.getLastName())
                .email(workshopFormDAO.getEmail())
                .phoneNumber(workshopFormDAO.getPhoneNumber())
                .city(workshopFormDAO.getCity())
                .build();
    }

    public WorkshopDAO convertStringToWorkshopDAO(String workshop) {
        WorkshopDAO result;
        try{
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(workshop, WorkshopDAO.class);
            return result;

        } catch(Exception exception) {
            log.error(exception.getMessage(), exception);
        }
        return null;
    }

    public ContributorModel convertToContributorEntity(ContributorDAO contributorDAO){
        return ContributorModel.builder()
                .name(contributorDAO.getName())
                .city(contributorDAO.getCity())
                .website(contributorDAO.getWebsite())
                .description(contributorDAO.getDescription())
                .email(contributorDAO.getEmail())
                .phoneNumber(contributorDAO.getPhoneNumber())
                .build();
    }

    public ContributorDAO convertToContributorDAO(ContributorModel contributorModel){
        return ContributorDAO.builder()
                .id(contributorModel.getId())
                .city(contributorModel.getCity())
                .description(contributorModel.getDescription())
                .email(contributorModel.getEmail())
                .name(contributorModel.getName())
                .phoneNumber(contributorModel.getPhoneNumber())
                .website(contributorModel.getWebsite())
                .build();
    }

}


