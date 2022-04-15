package com.hackaton.hackback.workshopForm.service;

import com.hackaton.hackback.helper.ServiceHelper;
import com.hackaton.hackback.workshop.WorkshopModel;
import com.hackaton.hackback.workshop.WorkshopRepository;
import com.hackaton.hackback.workshopForm.WorkshopFormDAO;
import com.hackaton.hackback.workshopForm.WorkshopFormModel;
import com.hackaton.hackback.workshopForm.WorkshopFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class WorkshopFormServiceImpl implements WorkshopFormService {
    private WorkshopFormRepository workshopFormRepository;
    private WorkshopRepository workshopRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public WorkshopFormServiceImpl(WorkshopFormRepository workshopFormRepository, WorkshopRepository workshopRepository, ServiceHelper serviceHelper) {
        this.workshopFormRepository = workshopFormRepository;
        this.workshopRepository = workshopRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<WorkshopFormModel> findAll() {
        return workshopFormRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addWorkshopForm(WorkshopFormDAO workshopFormDAO, UUID formId) {
        Optional<WorkshopModel> workshopModel = workshopRepository.findById(formId);

        if(workshopModel.isPresent()){
            WorkshopFormModel workshopForm = serviceHelper.convertToWorkshopFormEntity(workshopFormDAO);
            workshopForm.setWorkshop(workshopModel.get());

            workshopFormRepository.save(workshopForm);

            return new ResponseEntity<>(workshopForm, HttpStatus.OK);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no workshop found");
        }

    }

    @Override
    public ResponseEntity<?> findWorkshopForm(UUID formId) {
        WorkshopFormModel workshopFormModel = workshopFormRepository.findByWorkshopId(formId);
        WorkshopFormDAO workshopFormDAO = serviceHelper.convertToWorkshopFormDAO(workshopFormModel);

        return new ResponseEntity<>(workshopFormDAO, HttpStatus.OK);
    }
}
