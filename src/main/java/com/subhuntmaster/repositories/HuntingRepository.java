package com.subhuntmaster.repositories;

import com.subhuntmaster.domain.Hunting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HuntingRepository  extends JpaRepository<Hunting, Long> {
}
