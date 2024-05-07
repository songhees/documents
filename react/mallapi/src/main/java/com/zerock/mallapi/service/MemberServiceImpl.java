package com.zerock.mallapi.service;

import com.zerock.mallapi.domain.Member;
import com.zerock.mallapi.domain.MemberRole;
import com.zerock.mallapi.dto.MemberDTO;
import com.zerock.mallapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repository;

    private final PasswordEncoder encoder;

    private String makeTempPassword() {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 10; i++) {
            buffer.append((char) ((int)(Math.random()*55) + 65));
        }
        return buffer.toString();
    }

    private Member makeSocialMember(String email) {
        String tempPassword = makeTempPassword();
        String nickname = "social";

        Member member = Member.builder()
                .email(email)
                .pw(encoder.encode(tempPassword))
                .nickname(nickname)
                .social(true)
                .build();
        member.addRole(MemberRole.USER);
        return member;
    }
    @Override
    public MemberDTO getKakaoMember(String accessToken) {

        String email = getEmailFromKakaoAccessToken(accessToken);
        Optional<Member> member = repository.findById(email);
        if (member.isPresent()) {
            MemberDTO memberDTO = entityToDTO(member.get());
            return memberDTO;
        }
        Member socialMember = makeSocialMember(email);
        repository.save(socialMember);
        MemberDTO memberDTO = entityToDTO(socialMember);
        return memberDTO;
    }

    private String getEmailFromKakaoAccessToken(String accessToken) {

        String kakaoGetUserURL = "https://kapi.kakao.com/v2/user/me";

        if (accessToken == null) {
            throw new RuntimeException("Access Token is null");
        }
        RestClient restClient = RestClient.create();

        LinkedHashMap<String, LinkedHashMap> result = restClient.get()
                .uri(kakaoGetUserURL)
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .body(LinkedHashMap.class);

        LinkedHashMap<String, String> kakaoAccount = result.get("kakao_account");
        log.info(kakaoAccount.toString());
        return kakaoAccount.get("email");
    }
}
