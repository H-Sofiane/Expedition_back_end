package com.wws.services;

import java.util.List;
import com.wws.dtos.MemberDTO;
import com.wws.exceptions.MemberNotFoundException;

public interface MemberService {
	MemberDTO saveMember(MemberDTO memberDTO);
	List<MemberDTO> listMembers();
	MemberDTO getMember(Long memberId) throws MemberNotFoundException;
	MemberDTO updateMember(MemberDTO memberDTO);
    void deleteMember(Long memberId);
    List<MemberDTO> searchMembers(String keyword);
}
