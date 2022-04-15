package com.hackaton.hackback.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
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

}


