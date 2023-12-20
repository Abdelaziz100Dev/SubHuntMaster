package com.subhuntmaster.repositories;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    Competition findByCode(String code);
    Page<Competition> findAll(Pageable pageable);
//    @Query("SELECT c, m FROM Competition c LEFT JOIN c.members m WHERE m IS NULL")
//    Page<Object[]> findCompetitionWithNonAssociatedMembers(Pageable pageable);
}
