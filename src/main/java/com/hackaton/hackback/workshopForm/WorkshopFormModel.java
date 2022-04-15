package com.hackaton.hackback.workshopForm;

import com.hackaton.hackback.workshop.WorkshopModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkshopFormModel {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    @Column(name = "workshopForm_id")
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "workshop_id", referencedColumnName = "workshop_id")
    private WorkshopModel workshop;
}
