package com.subhuntmaster.services;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.CompetitionRepository;
import com.subhuntmaster.services.interfaces.CompetitionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
       return competitionRepository.save(competition);

    }

    @Override
    public Competition getCompetitionByCode(String code) {
        return competitionRepository.findByCode(code);
    }

    @Override
    public List<CompetitionDto> getAll() {
        List<CompetitionDto> competitionDtoList = new ArrayList<CompetitionDto>();
        competitionRepository.findAll().forEach(competition -> competitionDtoList.add(projectMapper.toDto(competition)));
        return competitionDtoList;
    }

    @Override
    public Competition deleteByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            competitionRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Competition deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where the competition with the given ID is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competition not found");
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during competition deletion");
        }
    }

    @Override
    public Competition getCompetitionById(Long id) {
        return null;
    }

    @Override
    public Competition update(Long id, Competition competition) {
        Competition getedcompetition = competitionRepository.findById(id).get();

        getedcompetition.setCode(competition.getCode());
        getedcompetition.setDate(competition.getDate());
        getedcompetition.setStartTime(competition.getStartTime());
        getedcompetition.setEndTime(competition.getEndTime());
        getedcompetition.setNumberOfParticipants(competition.getNumberOfParticipants());
        getedcompetition.setLocation(competition.getLocation());
        getedcompetition.setAmount(competition.getAmount());

        return competitionRepository.save(getedcompetition);
    }
}
