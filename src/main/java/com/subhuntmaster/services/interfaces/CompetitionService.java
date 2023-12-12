package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Competition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CompetitionService {

    Competition save(Competition demand);
    Competition getDemandById(Long id);

    List<Competition> getAll();

}
