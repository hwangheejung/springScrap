package com.example.demo.member.mapper;

import com.example.demo.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

  void createMember(Member member);

}
