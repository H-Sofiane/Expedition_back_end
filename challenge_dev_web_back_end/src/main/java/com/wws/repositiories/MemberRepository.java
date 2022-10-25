package com.wws.repositiories;


import com.wws.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long> {
	@Query("select m from Member m where m.name like :kw")
    List<Member> searchMember(@Param("kw") String keyword);
}
