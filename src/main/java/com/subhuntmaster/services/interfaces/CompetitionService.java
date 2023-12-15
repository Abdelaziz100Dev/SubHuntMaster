package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CompetitionService {

    Competition save(Competition competition);
    Competition getCompetitionByCode(String code);
    List<CompetitionDto> getAll();
    Competition deleteByCode(String code);
    ResponseEntity<String> deleteById(Long id);

    Competition getCompetitionById(Long id);
    Competition update(Long id, Competition competition);


}
