package com.subhuntmaster.repositories;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Ranking;
import com.subhuntmaster.domain.RankingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankingKey> {
    Ranking getRankingByCompetition_idAndMember_id(Long Competition_id,Long Member_id);

    List<Ranking> findByCompetition(Competition competition);
}
