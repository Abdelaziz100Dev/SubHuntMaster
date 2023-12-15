package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Level;
import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.MemberDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LevelService {
    ResponseEntity<Level> save(Level level);
    ResponseEntity<String> delete(Long id);
    List<Level> getAll();
    ResponseEntity<Level> getLevelById(Long id);

    ResponseEntity<Level> update(Long id, Level level);
}
