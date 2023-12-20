package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Member;
import com.subhuntmaster.domain.Ranking;
import com.subhuntmaster.domain.RankingKey;
import com.subhuntmaster.dto.responseDto.RankingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RankingService{
    RankingDto save(RankingDto ranking);
    ResponseEntity<String> delete(Long id);
    List<Ranking> getAll();
    Ranking getRankingById(RankingKey id);

    ResponseEntity<Ranking> update(Long id, Ranking ranking);
}
