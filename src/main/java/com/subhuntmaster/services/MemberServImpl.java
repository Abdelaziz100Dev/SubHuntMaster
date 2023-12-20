package com.subhuntmaster.services;

import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.MemberDto;
import com.subhuntmaster.mappers.ProjectMapper;
import com.subhuntmaster.repositories.MemberRepository;
import com.subhuntmaster.services.interfaces.MemberService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MemberServImpl  implements MemberService {
    MemberRepository memberRepository;
    ProjectMapper projectMapper;
    public MemberServImpl(MemberRepository memberRepository, ProjectMapper projectMapper){
        this.memberRepository=memberRepository;
        this.projectMapper=projectMapper;
    }
    @Override
    public ResponseEntity<Member> save(Member member) {

        return new ResponseEntity(projectMapper.toDto(memberRepository.save(member)), HttpStatus.CREATED) ;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        try {
            memberRepository.deleteById(id);
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
    public List<MemberDto> getAll() {
        List<MemberDto> memberDtoList = new ArrayList<>();
        memberRepository.findAll().forEach(entityMember-> memberDtoList.add(projectMapper.toDto(entityMember)));
        return memberDtoList;
    }

    @Override
    public ResponseEntity<Member> getMemberById(Long id) {
        if(memberRepository.findById(id).isPresent()){
            return new ResponseEntity<>(memberRepository.findById(id).get(),HttpStatus.OK); }
        else
            return new ResponseEntity<>( null,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Member> update(Long id, Member member) {

        if(memberRepository.findById(id).isPresent()){
            Member getedMember = memberRepository.findById(id).get();
                getedMember.setFirstName(member.getFirstName());
                getedMember.setLastName(member.getLastName());
                getedMember.setAccessionDate(member.getAccessionDate());
                getedMember.setIdentityDocument(member.getIdentityDocument());
                getedMember.setIdentityNumber(member.getIdentityNumber());
                getedMember.setNationality(member.getNationality());
                getedMember.setNumber(member.getNumber());
                memberRepository.save(getedMember);
            return new ResponseEntity<>(getedMember,HttpStatus.OK);

        }else  return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
}
