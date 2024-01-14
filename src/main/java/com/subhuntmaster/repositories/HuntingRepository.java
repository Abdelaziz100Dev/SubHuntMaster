package com.subhuntmaster.repositories;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.domain.Hunting;
import com.subhuntmaster.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuntingRepository  extends JpaRepository<Hunting, Long> {
}
