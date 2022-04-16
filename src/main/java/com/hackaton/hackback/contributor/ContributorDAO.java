package com.hackaton.hackback.contributor;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ContributorDAO {
    private UUID id;

    private String name;
    private String email;
    private String phoneNumber;
    private String website;
    private String description;
    private String city;
}
