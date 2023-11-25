package umcHomework.umc1.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umcHomework.umc1.domain.member.dto.LoginRequestDto;
import umcHomework.umc1.domain.member.dto.MemberRequestDto;
import umcHomework.umc1.domain.member.dto.MemberResponseDto;
import umcHomework.umc1.domain.member.dto.TokenRequestDto;
import umcHomework.umc1.domain.member.entity.Authority;
import umcHomework.umc1.domain.member.entity.Member;
import umcHomework.umc1.domain.member.entity.RefreshToken;
import umcHomework.umc1.domain.member.repository.MemberRepository;
import umcHomework.umc1.domain.member.repository.RefreshTokenRepository;
import umcHomework.umc1.global.security.jwt.TokenProvider;
import umcHomework.umc1.global.security.jwt.dto.TokenDto;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public MemberResponseDto signup(MemberRequestDto memberRequestDto){
        if(memberRepository.existsByEmail(memberRequestDto.getEmail())){
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }
        String password = passwordEncoder.encode(memberRequestDto.getEmail());

        Member member = Member.builder()
                .email(memberRequestDto.getEmail())
                .name(memberRequestDto.getName())
                .bDay(memberRequestDto.getBDay())
                .nickname(memberRequestDto.getNickname())
                .phoneNum(memberRequestDto.getPhoneNum())
                .password(memberRequestDto.getPassword())
                .authority(Authority.valueOf("ROLE_USER"))
                .build();

        memberRepository.save(member);
        return MemberResponseDto.of(member);
    }

    public Object login(LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());
        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);
        return tokenDto;
    }

    @Transactional
    public Object reissue(TokenRequestDto tokenRequestDto) {
        // 1. Refresh Token 검증
        if(!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())){
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // 2. Access Token에서 Member ID 가져오기
        Authentication authentication =
                tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // 3. 저장소에서 Member ID를 기반으로 Refresh Token 값 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자 입니다."));

        // 4. Refresh Token 일치하는지 검사
        if(!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())){
            throw new RuntimeException("토큰의 유저 정보가 일차하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);

        // 6. 저장소 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        // 토큰 방급
        return tokenDto;
    }


}
