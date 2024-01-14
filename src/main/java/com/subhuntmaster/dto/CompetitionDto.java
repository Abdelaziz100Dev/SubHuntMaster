package com.subhuntmaster.dto;

import com.subhuntmaster.domain.Member;
import com.subhuntmaster.enums.competitionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDto {
    private Long id;
    private String code;
    private competitionStatus status;

    private Date startTime;
    private Date endTime;
}
