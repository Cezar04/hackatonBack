package com.hackaton.hackback.workshopForm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkshopFormRepository extends JpaRepository<WorkshopFormModel, UUID> {
    Optional<WorkshopFormModel> findById(UUID formId);
    WorkshopFormModel findByWorkshopId(UUID workshopId);
    boolean existsByWorkshopId(UUID workshopId);
}
