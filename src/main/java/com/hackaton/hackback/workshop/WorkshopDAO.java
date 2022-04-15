package com.hackaton.hackback.workshop;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkshopDAO {
    private UUID id;

    private String Title;
    private String subTitle;
    private String description;
    private byte[] image;
    private String startDate;
    private String endDate;
}
