package com.wws;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wws.entities.Member;
import com.wws.repositiories.MemberRepository;

@SpringBootTest
class ChallengeDevWebBackEndApplicationTests {
	
	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void testAddMember() {
		Member member = new Member();
		member.setName("Sofiane");
		memberRepository.save(member);
	}

}
