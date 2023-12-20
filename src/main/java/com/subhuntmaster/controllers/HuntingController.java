package com.subhuntmaster.controllers;

import com.subhuntmaster.domain.Hunting;
import com.subhuntmaster.dto.HuntingDto;
import com.subhuntmaster.services.HuntingServImpl;
import com.subhuntmaster.services.interfaces.HuntingService;
import com.subhuntmaster.services.interfaces.HuntingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hunting")
@Transactional
public class HuntingController {
    HuntingService huntingService;

    public HuntingController(HuntingService huntingServiceImpl) {
        this.huntingService = huntingServiceImpl;
    }

//    @GetMapping("")
//    public ResponseEntity<List<HuntingDto>> getAll() {
//        return  new ResponseEntity<>(huntingService.getAll(), HttpStatus.OK);
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Hunting> getHuntingById(Long id) {
//        return  new ResponseEntity<>(huntingService.getHuntingById(id), HttpStatus.OK);
//    }

//    @PostMapping("")
//    public ResponseEntity<HuntingDto> save(@RequestBody Hunting hunting) {
////        return new ResponseEntity<>(null, HttpStatus.OK);
//        return  new ResponseEntity<>(huntingService.save(hunting), HttpStatus.OK);
//    }
}
