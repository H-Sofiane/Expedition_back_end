package com.wws.services;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.wws.dtos.MemberDTO;
import com.wws.entities.Member;
import com.wws.exceptions.MemberNotFoundException;
import com.wws.mappers.MemberMapperImpl;
import com.wws.repositiories.MemberRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {
	
	private MemberRepository memberRepository;
	private MemberMapperImpl dtoMapper;

	@Override
	public MemberDTO saveMember(MemberDTO memberDTO) {
		log.info("Saving new Member");
		Member member=dtoMapper.fromMemberDTO(memberDTO);
		Member savedMember = memberRepository.save(member);
        return dtoMapper.fromMember(savedMember);
	}

	@Override
	public List<MemberDTO> listMembers() {
		List<Member> members = memberRepository.findAll();
        List<MemberDTO> memberDTOS = members.stream()
                .map(member -> dtoMapper.fromMember(member))
                .collect(Collectors.toList());        
        return memberDTOS;
	}

	@Override
	public MemberDTO getMember(Long memberId) throws MemberNotFoundException {
		Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member Not found"));
        return dtoMapper.fromMember(member);
	}

	@Override
	public MemberDTO updateMember(MemberDTO memberDTO) {
		log.info("Saving new Member");
		Member member=dtoMapper.fromMemberDTO(memberDTO);
		Member savedMember = memberRepository.save(member);
        return dtoMapper.fromMember(savedMember);
	}

	@Override
	public void deleteMember(Long memberId) {
		memberRepository.deleteById(memberId);

	}

	@Override
	public List<MemberDTO> searchMembers(String keyword) {
		List<Member> members=memberRepository.searchMember(keyword);
        List<MemberDTO> memberDTOS = members.stream().map(mbr -> dtoMapper.fromMember(mbr)).collect(Collectors.toList());
        return memberDTOS;
	}

}
