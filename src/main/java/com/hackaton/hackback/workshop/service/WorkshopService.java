package com.hackaton.hackback.workshop.service;

import com.hackaton.hackback.workshop.WorkshopDAO;
import com.hackaton.hackback.workshop.WorkshopModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface WorkshopService {
    List<WorkshopDAO> findAll();
    ResponseEntity<?> addWorkshop(MultipartFile file, String workshop) throws IOException;
    ResponseEntity<?> findWorkshopById(UUID workshopId);
    ResponseEntity<?> deleteWorkshop(UUID workshopId);
    ResponseEntity<?> updateWorkshop(WorkshopDAO workshopDAO, UUID workshopId);
}
