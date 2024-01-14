package com.subhuntmaster.services;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Hunting;
import com.subhuntmaster.domain.Ranking;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.dto.responseDto.RankingDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.CompetitionRepository;
import com.subhuntmaster.repositories.HuntingRepository;
import com.subhuntmaster.repositories.MemberRepository;
import com.subhuntmaster.repositories.RankingRepository;
import com.subhuntmaster.services.interfaces.CompetitionService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetitionServImpl implements CompetitionService {
    CompetitionRepository competitionRepository;
    ProjectMapper projectMapper;
    private final MemberRepository memberRepository;


    public CompetitionServImpl(CompetitionRepository competitionRepository, ProjectMapper projectMapper,
                               MemberRepository memberRepository, HuntingRepository huntingRepository, RankingRepository rankingRepository) {
        this.competitionRepository = competitionRepository;
        this.projectMapper = projectMapper;

        this.memberRepository = memberRepository;
    }
    @Override
    public CompetitionDto save(Competition competition) {
       return projectMapper.toDto(competitionRepository.save(competition));

    }

    @Override
    public Competition getCompetitionByCode(String code) {
        return competitionRepository.findByCode(code);
    }

    @Override
    public Page<CompetitionDto> getAll(Pageable pageable) {
        List<CompetitionDto> competitionDtoList = new ArrayList<>();
        competitionRepository.findAll(pageable)
                .forEach(competition -> competitionDtoList.add(projectMapper.toDto(competition)));
        return new PageImpl<>(competitionDtoList, pageable, competitionRepository.count());
    }

    @Override
    public Competition deleteByCode(String code) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        try {
            competitionRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Competition deleted successfully");
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
