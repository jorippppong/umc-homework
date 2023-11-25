package umcHomework.umc1.domain.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umcHomework.umc1.domain.member.dto.LoginRequestDto;
import umcHomework.umc1.domain.member.dto.MemberRequestDto;
import umcHomework.umc1.domain.member.dto.MemberResponseDto;
import umcHomework.umc1.domain.member.dto.TokenRequestDto;
import umcHomework.umc1.domain.member.service.AuthService;
import umcHomework.umc1.global.security.jwt.dto.TokenDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "회원 가입") //swagger
    public ResponseEntity<MemberResponseDto> signup(
            @RequestBody MemberRequestDto memberRequestDto
    ){
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login (
            @RequestBody LoginRequestDto loginRequestDto
    ){
        return ResponseEntity.ok((TokenDto) authService.login(loginRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(
            @RequestBody TokenRequestDto tokenRequestDto
    ){
        return ResponseEntity.ok((TokenDto) authService.reissue(tokenRequestDto));
    }



}
