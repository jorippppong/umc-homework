package umcHomework.umc1.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequestDto {
    private String accessToken;
    private String refreshToken;
}
