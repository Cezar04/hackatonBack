package com.hackaton.hackback.workshop.service;

import com.hackaton.hackback.helper.ServiceHelper;
import com.hackaton.hackback.workshop.WorkshopDAO;
import com.hackaton.hackback.workshop.WorkshopModel;
import com.hackaton.hackback.workshop.WorkshopRepository;
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
public class WorkshopServiceImpl implements WorkshopService{
    private WorkshopRepository workshopRepository;
    private ServiceHelper serviceHelper;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository, ServiceHelper serviceHelper) {
        this.workshopRepository = workshopRepository;
        this.serviceHelper = serviceHelper;
    }

    @Override
    public List<WorkshopDAO> findAll() {
        List<WorkshopDAO> allWorkshops = new ArrayList<>();
        Iterable<WorkshopModel> workshop = workshopRepository.findAll();
        workshop.forEach(workshopModel -> allWorkshops.add(serviceHelper.convertToWorkshopDAO(workshopModel)));
        return allWorkshops;
    }

    @Override
    public ResponseEntity<?> addWorkshop(WorkshopDAO workshopDAO) {

        WorkshopModel workshop = serviceHelper.convertToWorkshopEntity(workshopDAO);
        workshopRepository.save(workshop);

        return new ResponseEntity<>(workshop, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findWorkshopById(UUID workshopId) {
        WorkshopModel workshop = workshopRepository.findById(workshopId).get();
        WorkshopDAO workshopDAO = serviceHelper.convertToWorkshopDAO(workshop);
        return new ResponseEntity<>(workshopDAO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteWorkshop(UUID workshopId) {
        Optional<WorkshopModel> workshopModel = workshopRepository.findById(workshopId);
        if (workshopModel.isPresent()){
            WorkshopModel workshop = workshopModel.get();
            workshopRepository.delete(workshop);

            return new ResponseEntity<>(workshop, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("no record found to delete!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> updateWorkshop(WorkshopDAO workshopDAO, UUID workshopId) {
        return null;
    }
}
