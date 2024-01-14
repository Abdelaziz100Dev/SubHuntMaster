package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.dto.responseDto.RankingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CompetitionService {

    CompetitionDto save(Competition competition);
    Competition getCompetitionByCode(String code);
    Page<CompetitionDto> getAll(Pageable pageable);
    Competition deleteByCode(String code);
    ResponseEntity<String> deleteById(Long id);

    Competition getCompetitionById(Long id);
    Competition update(Long id, Competition competition);



}
