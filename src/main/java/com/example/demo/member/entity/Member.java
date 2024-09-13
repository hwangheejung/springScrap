package com.example.demo.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자
public class Member {

  private Long memberId;
  private String email;
  private String password;

  @Builder
  public Member(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
