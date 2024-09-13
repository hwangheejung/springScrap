package com.example.demo.member.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자
@ToString
public class Member {

  private Long memberId;
  private String email;
  private String password;

  @Builder
  public Member(Long memberId,String email, String password) {
    this.memberId = memberId;
    this.email = email;
    this.password = password;
  }
}
