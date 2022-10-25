package com.wws.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.wws.dtos.MemberDTO;
import com.wws.entities.Member;

@Service
public class MemberMapperImpl {
	public MemberDTO fromMember(Member member){
		MemberDTO memberDTO=new MemberDTO();
        BeanUtils.copyProperties(member,memberDTO);
        return  memberDTO;
    }
    public Member fromMemberDTO(MemberDTO memberDTO){
    	Member member=new Member();
        BeanUtils.copyProperties(memberDTO,member);
        return  member;
    }
}
