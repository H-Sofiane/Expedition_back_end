package com.wws.web;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wws.dtos.MemberDTO;
import com.wws.exceptions.MemberNotFoundException;
import com.wws.services.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class MemberRestController {
	
	private MemberService memberService;
	
	@GetMapping("/members")
    public List<MemberDTO> members(){
        return memberService.listMembers();
    }
    @GetMapping("/members/search")
    public List<MemberDTO> searchMembers(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return memberService.searchMembers("%"+keyword+"%");
    }
    @GetMapping("/members/{id}")
    public MemberDTO getMember(@PathVariable(name = "id") Long memberId) throws MemberNotFoundException {
        return memberService.getMember(memberId);
    }
    @PostMapping("/members")
    public MemberDTO saveMember(@RequestBody MemberDTO memberDTO){
        return memberService.saveMember(memberDTO);
    }
    @PutMapping("/members/{memberId}")
    public MemberDTO updateMember(@PathVariable Long memberId, @RequestBody MemberDTO memberDTO){
        memberDTO.setId(memberId);
        return memberService.updateMember(memberDTO);
    }
    @DeleteMapping("/members/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

}
