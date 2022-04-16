package com.hackaton.hackback.contributor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContributorModel {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "contributor_id")
    private UUID id;

    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String description;
    private String city;

}
