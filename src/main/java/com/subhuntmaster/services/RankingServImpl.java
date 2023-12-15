package com.subhuntmaster.services;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Member;
import com.subhuntmaster.domain.Ranking;
import com.subhuntmaster.domain.RankingKey;
import com.subhuntmaster.dto.responseDto.RankingDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.RankingRepository;
import com.subhuntmaster.services.interfaces.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RankingServImpl implements RankingService {
    RankingRepository rankingRepository;
    ProjectMapper projectMapper;
    public RankingServImpl(RankingRepository rankingRepository,ProjectMapper projectMapper){
        this.rankingRepository=rankingRepository;
        this.projectMapper=projectMapper;
    }
    @Override
    public RankingDto save(Ranking ranking) {
        canRankBeSaved(ranking);
        return   projectMapper.toRankingDto(rankingRepository.save(ranking));

    }

    private void canRankBeSaved(Ranking ranking) {
        if(rankingRepository.existsById(ranking.getId())) {
            throw new IllegalArgumentException("Rank already exists");
        }
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }

    @Override
    public List<Ranking> getAll() {
        return null;
    }

    @Override
    public Ranking getRankingById(RankingKey id) {
        return rankingRepository.getById(id);
    }

    @Override
    public ResponseEntity<Ranking> update(Long id, Ranking ranking) {
        return null;
    }
}
