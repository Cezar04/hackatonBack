package com.hackaton.hackback.contributor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContributorRepository extends JpaRepository<ContributorModel, UUID> {
    Optional<ContributorModel> findById(UUID contributorId);

}
