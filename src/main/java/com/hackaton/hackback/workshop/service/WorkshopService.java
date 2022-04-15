package com.hackaton.hackback.workshop.service;

import com.hackaton.hackback.workshop.WorkshopDAO;
import com.hackaton.hackback.workshop.WorkshopModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface WorkshopService {
    List<WorkshopDAO> findAll();
    ResponseEntity<?> addWorkshop(WorkshopDAO workshopDAO);
    ResponseEntity<?> findWorkshopById(UUID workshopId);
    ResponseEntity<?> deleteWorkshop(UUID workshopId);
    ResponseEntity<?> updateWorkshop(WorkshopDAO workshopDAO, UUID workshopId);
}
