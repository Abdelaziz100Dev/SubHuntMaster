package com.subhuntmaster.services;

import com.subhuntmaster.domain.Level;
import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.MemberDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.LevelRepository;
import com.subhuntmaster.services.interfaces.LevelService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class LevelServImpl implements LevelService {
    LevelRepository levelRepository;
    ProjectMapper projectMapper;
    public LevelServImpl(LevelRepository levelRepository,ProjectMapper projectMapper){
        this.levelRepository=levelRepository;
        this.projectMapper=projectMapper;
    }

    @Override
    public ResponseEntity<Level> save(Level level) {
        return new ResponseEntity(levelRepository.save(level), HttpStatus.CREATED) ;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            levelRepository.deleteById(id);
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
    public List<Level> getAll() {
//        List<MemberDto> memberDtoList = new ArrayList<>();
//        levelRepository.findAll().forEach(entityMember-> memberDtoList.add(projectMapper.toDto(entityMember)));
        return levelRepository.findAll();
    }

    @Override
    public ResponseEntity<Level> getLevelById(Long id) {
        if(levelRepository.findById(id).isPresent()){
            return new ResponseEntity<>(levelRepository.findById(id).get(),HttpStatus.OK); }
        else
            return new ResponseEntity<>( null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Level> update(Long id, Level level) {

            if(levelRepository.findById(id).isPresent()){
                Level getedLevel = levelRepository.findById(id).get();
                getedLevel.setCode(level.getCode());
                getedLevel.setDescription(level.getDescription());
                getedLevel.setPoints(level.getPoints());

                return new ResponseEntity<>(levelRepository.save(getedLevel),HttpStatus.OK);
            }
            else
                return new ResponseEntity<>( null,HttpStatus.NOT_FOUND);
    }
}
