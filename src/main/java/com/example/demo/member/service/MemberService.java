package com.example.demo.member.service;

import com.example.demo.member.dto.request.MemberCreate;
import com.example.demo.member.entity.Member;

//메소드 - 기능
public interface MemberService {

  void createMember(MemberCreate request);
}
