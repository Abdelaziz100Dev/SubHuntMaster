package com.subhuntmaster.controllers;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.services.interfaces.CompetitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition")
@Transactional
public class CompetitionController {
    CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("")
    public ResponseEntity<List<CompetitionDto>>  getAll() {
        return  new ResponseEntity<>(competitionService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Competition> getCompetitionByCode(String code) {
        return  new ResponseEntity<>(competitionService.getCompetitionByCode(code), HttpStatus.OK);
    }
    @GetMapping("/{id}")

    @PostMapping("")
    public ResponseEntity<Competition> save(@RequestBody Competition competition) {
        return  new ResponseEntity<>(competitionService.save(competition), HttpStatus.OK);
    }

//    @DeleteMapping("/{code}")
//    public ResponseEntity<Competition> delete(@PathVariable String code) {
//        return  new ResponseEntity<>(competitionService.delete(code), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return  competitionService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> update(@PathVariable Long id, @RequestBody Competition competition) {
        return  new ResponseEntity<>(competitionService.update(id, competition), HttpStatus.OK);
    }


}
