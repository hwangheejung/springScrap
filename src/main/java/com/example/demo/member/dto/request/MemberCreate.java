package com.example.demo.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor //모든 생성자
@Builder
public class MemberCreate {

  private Long memberId;
  private String email;
  private String password;

  public static MemberCreate of(Long memberId,String email, String password) { //팩토리 메소드
    return MemberCreate.builder()
        .memberId(memberId)
        .email(email)
        .password(password)
        .build();
  }
}
