package com.subhuntmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDto {
    private Long id;
    private String code;
    private Date startTime;
    private Date endTime;
}
