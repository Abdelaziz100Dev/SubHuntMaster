package com.subhuntmaster.mappers;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.dto.MemberDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProjectMapper {
    @Autowired
    private ModelMapper modelMapper;

    public <S, T> T map(S source, Class<T> targetClass) {
        return Objects.isNull(source) ? null : modelMapper.map(source, targetClass);
    }

    public MemberDto toDto(Member memberEntity) {
        return Objects.isNull(memberEntity) ? null : modelMapper.map(memberEntity, MemberDto.class);
    }

    public CompetitionDto toDto(Competition competitionEntity) {
        return Objects.isNull(competitionEntity) ? null : modelMapper.map(competitionEntity, CompetitionDto.class);
    }

}
