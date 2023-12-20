package com.subhuntmaster.controllers;

import com.subhuntmaster.domain.Member;
import com.subhuntmaster.dto.CompetitionDto;
import com.subhuntmaster.dto.MemberDto;
import com.subhuntmaster.services.interfaces.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
@Transactional
public class MemberController {
    private  MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("")
    public List<MemberDto> getAll( ) {
        return  memberService.getAll();
    }

    @PostMapping("")
    public ResponseEntity<Member>  save(@RequestBody Member member) {
        return  memberService.save(member);
    }
}
