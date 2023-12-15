package com.subhuntmaster.controllers;

import com.subhuntmaster.domain.Ranking;
import com.subhuntmaster.dto.responseDto.RankingDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.RankingRepository;
import com.subhuntmaster.services.interfaces.RankingService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ranking")
@Transactional
public class RankingController {
    RankingService rankingService;
    RankingRepository rankingRepository;
    ProjectMapper projectMapper;
    public RankingController(RankingService rankingService,RankingRepository rankingRepository,ProjectMapper projectMapper){
        this.rankingService=rankingService;
        this.rankingRepository=rankingRepository;
        this.projectMapper=projectMapper;
    }

    @PostMapping("")
    public RankingDto save(@RequestBody Ranking ranking){
            return rankingService.save(ranking);
    }

}
