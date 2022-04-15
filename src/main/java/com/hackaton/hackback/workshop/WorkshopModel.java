package com.hackaton.hackback.workshop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "workshop")
public class WorkshopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "pg-uuid")
    @Column(name = "workshop_id")
    private UUID id;

    private String Title;
    private String subTitle;
    private String description;
    private byte[] image;
    private String startDate;
    private String endDate;

    //TODO baga poza



}
