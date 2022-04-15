package com.hackaton.hackback.helper;

import com.hackaton.hackback.workshop.WorkshopDAO;
import com.hackaton.hackback.workshop.WorkshopModel;
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

}
