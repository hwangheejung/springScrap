package com.example.demo.member.service;

import com.example.demo.member.dto.request.MemberCreate;
import com.example.demo.member.entity.Member;
import com.example.demo.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

  private final MemberMapper mapper;
  @Override
  public void createMember(MemberCreate request) {
    System.out.println("2");
    Member member = Member.builder()
        .memberId(request.getMemberId())
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
    System.out.println("member = " + member.toString());
    mapper.createMember(member);
    System.out.println("3");
  }



}
