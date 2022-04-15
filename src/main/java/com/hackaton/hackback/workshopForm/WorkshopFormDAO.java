package com.hackaton.hackback.workshopForm;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkshopFormDAO {
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;

}
