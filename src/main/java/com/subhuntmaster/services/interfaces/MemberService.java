package com.subhuntmaster.services.interfaces;

import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.MemberDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    ResponseEntity<Member> save(Member member);
    ResponseEntity<String> delete(Long id);
    List<MemberDto> getAll();
    ResponseEntity<Member> getMemberById(Long id);

    ResponseEntity<Member> update(Long id, Member member);
}
