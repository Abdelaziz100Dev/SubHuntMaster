package com.subhuntmaster.services;

import com.subhuntmaster.domain.Hunting;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.HuntingRepository;
import com.subhuntmaster.services.interfaces.HuntingService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HuntingServImpl implements HuntingService {

    HuntingRepository huntingRepository;
    ProjectMapper projectMapper;
    public HuntingServImpl(HuntingRepository huntingRepository, ProjectMapper projectMapper){

        this.projectMapper=projectMapper;
    }

    @Override
    public ResponseEntity<Hunting> save(Hunting hunting) {
        return new ResponseEntity(huntingRepository.save(hunting), HttpStatus.CREATED) ;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            huntingRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Competition deleted successfully");
        } catch (EmptyResultDataAccessException e) {
            // Handle the case where the competition with the given ID is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Competition not found");
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during competition deletion");
        }
    }

    @Override
    public List<Hunting> getAll() {
        return huntingRepository.findAll();
    }

    @Override
    public ResponseEntity<Hunting> getLevelById(Long id) {
        if(huntingRepository.findById(id).isPresent()){
            return new ResponseEntity<>(huntingRepository.findById(id).get(),HttpStatus.OK); }
        else
            return new ResponseEntity<>( null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Hunting> update(Long id, Hunting hunting) {

        if(huntingRepository.findById(id).isPresent()){
            Hunting getedHunting = huntingRepository.findById(id).get();
            getedHunting.setNumberOfFish(hunting.getNumberOfFish());
            getedHunting.setMember(hunting.getMember());
            return new ResponseEntity<>(huntingRepository.save(getedHunting),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>( null,HttpStatus.NOT_FOUND);
    }
}
