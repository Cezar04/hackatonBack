package com.hackaton.hackback.workshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkshopRepository  extends JpaRepository<WorkshopModel, UUID> {
    Optional<WorkshopModel> findById(UUID workshopId);

}
