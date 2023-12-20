package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Hunting;
import com.subhuntmaster.domain.Level;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HuntingService {
    ResponseEntity<Hunting> save(Hunting hunting);
    ResponseEntity<String> delete(Long id);
    List<Hunting> getAll();
    ResponseEntity<Hunting> getLevelById(Long id);

    ResponseEntity<Hunting> update(Long id, Hunting hunting);
}
