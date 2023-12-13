package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CompetitionService {

    Competition save(Competition competition);
    Competition getDemandById(Long id);

    List<CompetitionDto> getAll();

}
