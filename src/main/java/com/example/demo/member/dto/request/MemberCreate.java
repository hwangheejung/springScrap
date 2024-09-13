package com.example.demo.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor //모든 생성자
@Builder
public class MemberCreate {

  private Long email;
  private String password;

  public static MemberCreate of(Long email, String password) { //팩토리 메소드
    return MemberCreate.builder()
        .email(email)
        .password(password)
        .build();
  }
}
