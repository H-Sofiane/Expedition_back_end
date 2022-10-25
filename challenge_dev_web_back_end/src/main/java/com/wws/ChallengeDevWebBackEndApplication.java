package com.wws;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wws.dtos.MemberDTO;
import com.wws.entities.Member;
import com.wws.services.MemberService;

@SpringBootApplication
public class ChallengeDevWebBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeDevWebBackEndApplication.class, args);		
	}
	
	@Bean
	CommandLineRunner commandLineRunner(MemberService memberService) {
		return args -> {
			/*
			 * Stream.of("Eleftheria","Gennadios","Lysimachos").forEach(name->{ MemberDTO
			 * member=new MemberDTO(); member.setName(name);
			 * memberService.saveMember(member); });
			 */
		};
	}

}
