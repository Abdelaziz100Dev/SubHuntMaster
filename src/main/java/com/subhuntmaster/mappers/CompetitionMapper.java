package com.subhuntmaster.mappers;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;

public class CompetitionMapper {

    public static CompetitionDto toDto(Competition competition) {
        return CompetitionDto.builder()
                .code(competition.getCode())
                .startTime(competition.getStartTime())
                .endTime(competition.getEndTime())
                .build();
    }
}
