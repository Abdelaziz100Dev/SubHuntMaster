package com.subhuntmaster.services;

import com.subhuntmaster.domain.Fish;
import com.subhuntmaster.dto.FishDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.FishRepository;
import com.subhuntmaster.services.interfaces.FishService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class FishServImpl implements FishService {

    FishRepository fishRepository;
    ProjectMapper projectMapper;
    public FishServImpl(FishRepository fishRepository, ProjectMapper projectMapper){
        this.fishRepository = fishRepository;
        this.projectMapper = projectMapper;

    }


    @Override
    public Fish save(Fish fish) {
        return fishRepository.save(fish);
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            fishRepository.deleteById(id);
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
    public List<FishDto> getAll() {
        List<FishDto> fishDtosList = new ArrayList<FishDto>();
        fishRepository.findAll().forEach(entityFish->{
            fishDtosList.add(projectMapper.toDto(entityFish));
        });
        return fishDtosList;
    }

    @Override
    public ResponseEntity<Fish>  getFishById(Long id) {

        if(fishRepository.findById(id).isPresent()){
            return new ResponseEntity<>(fishRepository.findById(id).get(),HttpStatus.OK); }
        else
            return new ResponseEntity<>( null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Fish> update(Long id, Fish fish) {

           if ( fishRepository.findById(id).isPresent()){
               Fish getedfish = fishRepository.findById(id).get();
                   getedfish.setName(fish.getName());
                   getedfish.setAverageWeight(fish.getAverageWeight());
                   fishRepository.save(getedfish);
           return new ResponseEntity<>(getedfish,HttpStatus.OK);
           }else  return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

    }
}
