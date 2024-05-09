package com.zerock.mallapi.controller;

import com.zerock.mallapi.dto.MemberDTO;
import com.zerock.mallapi.dto.MemberModifyDTO;
import com.zerock.mallapi.service.MemberService;
import com.zerock.mallapi.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SocialController {
    private final MemberService service;

    @GetMapping("/api/member/kakao")
    public Map<String, Object> getMemberFromKakao(String accessToken) {
        MemberDTO memberDTO = service.getKakaoMember(accessToken);

        Map<String, Object> claims = memberDTO.getClaims();

        String jwtAccessToken = JWTUtil.generateToken(claims, 10);
        String jwtRefreshToken = JWTUtil.generateToken(claims, 60*24);

        claims.put("accessToken", jwtAccessToken);
        claims.put("refreshToken", jwtRefreshToken);

        return claims;
    }

    @PutMapping("/api/member/modify")
    public Map<String, String> modifyMember(@RequestBody MemberModifyDTO memberModifyDTO) {
        service.modifyMember(memberModifyDTO);
        return Map.of("result", "modified");
    }
}
