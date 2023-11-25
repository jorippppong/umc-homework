package umcHomework.umc1.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umcHomework.umc1.domain.member.entity.Authority;
import umcHomework.umc1.domain.member.entity.Member;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDto {
    private String name;
    private String nickname;
    private String phoneNum;
    private String bDay;
    private String email;
    private String password;
    private Authority authority;
}
