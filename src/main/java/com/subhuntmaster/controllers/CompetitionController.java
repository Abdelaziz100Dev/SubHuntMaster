package com.subhuntmaster.controllers;

import com.subhuntmaster.domain.Competition;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.services.interfaces.CompetitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("")
    public ResponseEntity<Competition> save(Competition competition) {
        return  new ResponseEntity<>(competitionService.save(competition), HttpStatus.OK);
    }
}
