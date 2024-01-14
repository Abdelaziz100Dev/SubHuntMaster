package com.subhuntmaster.controllers;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.services.interfaces.CompetitionService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/competition")
@Transactional
public class CompetitionController {
    CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("")
    public Page<CompetitionDto> getAll(Pageable pageable) {
        return  competitionService.getAll(pageable);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Competition> getCompetitionByCode(String code) {
        return  new ResponseEntity<>(competitionService.getCompetitionByCode(code), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(Long id) {
        return  new ResponseEntity<>(competitionService.getCompetitionById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CompetitionDto> save(@Valid @RequestBody Competition competition) {
//        return new ResponseEntity<>(null, HttpStatus.OK);
        return  new ResponseEntity<>(competitionService.save(competition), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return  competitionService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> update(@PathVariable Long id, @RequestBody Competition competition) {
        return  new ResponseEntity<>(competitionService.update(id, competition), HttpStatus.OK);
    }


}
