package com.subhuntmaster.services;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.mappers.CompetitionMapper;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.CompetitionRepository;
import com.subhuntmaster.services.interfaces.CompetitionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompetitionServImpl implements CompetitionService {
    CompetitionRepository competitionRepository;
    ProjectMapper projectMapper;


    public CompetitionServImpl(CompetitionRepository competitionRepository, ProjectMapper projectMapper) {
        this.competitionRepository = competitionRepository;
        this.projectMapper = projectMapper;

    }
    @Override
    public Competition save(Competition competition) {
        competitionRepository.save(competition);
        return null;
    }

    @Override
    public Competition getDemandById(Long id) {
        return null;
    }

    @Override
    public List<CompetitionDto> getAll() {
        List<CompetitionDto> competitionDtoList= new ArrayList<CompetitionDto>();
        competitionRepository.findAll().forEach(competition -> competitionDtoList.add(projectMapper.toDto(competition)));
        return competitionDtoList;
    }
}
