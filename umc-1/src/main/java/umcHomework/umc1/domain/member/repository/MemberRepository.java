package umcHomework.umc1.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umcHomework.umc1.domain.member.entity.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email); //이메일로 Member 찾기
    boolean existsByEmail(String email); //이메일로 Member 존재 여부 확인

}
