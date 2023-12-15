package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Fish;

import com.subhuntmaster.dto.FishDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FishService {
    Fish save(Fish fish);
    ResponseEntity<String> delete(Long id);
    List<FishDto> getAll();
    ResponseEntity<Fish> getFishById(Long id);
    ResponseEntity<Fish> update(Long id, Fish fish);
}
