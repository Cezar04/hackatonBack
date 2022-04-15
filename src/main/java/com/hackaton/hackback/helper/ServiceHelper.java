package com.hackaton.hackback.helper;

import com.hackaton.hackback.workshop.WorkshopDAO;
import com.hackaton.hackback.workshop.WorkshopModel;
import com.hackaton.hackback.workshopForm.WorkshopFormDAO;
import com.hackaton.hackback.workshopForm.WorkshopFormModel;
import org.springframework.stereotype.Component;

@Component
public class ServiceHelper {
    public WorkshopDAO convertToWorkshopDAO(WorkshopModel workshopModel){
        return WorkshopDAO.builder()
                .id(workshopModel.getId())
                .Title(workshopModel.getTitle())
                .subTitle(workshopModel.getSubTitle())
                .description(workshopModel.getDescription())
                .startDate(workshopModel.getStartDate())
                .endDate(workshopModel.getEndDate())
                .build();
    }

    public WorkshopModel convertToWorkshopEntity(WorkshopDAO workshopDAO){
        return WorkshopModel.builder()
                .Title(workshopDAO.getTitle())
                .subTitle(workshopDAO.getSubTitle())
                .description(workshopDAO.getDescription())
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

}


