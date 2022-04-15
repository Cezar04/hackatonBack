package com.hackaton.hackback.workshopForm.service;

import com.hackaton.hackback.workshopForm.WorkshopFormDAO;
import com.hackaton.hackback.workshopForm.WorkshopFormModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface WorkshopFormService {
    List<WorkshopFormModel> findAll();
    ResponseEntity<?> addWorkshopForm(WorkshopFormDAO workshopFormDAO, UUID formId);
    ResponseEntity<?> findWorkshopForm(UUID formId);

}
