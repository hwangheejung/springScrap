package com.example.demo.member.controller;

import com.example.demo.member.dto.request.MemberCreate;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor //final로 된 애를 생성자로 만들어준다.
@RestController
@RequestMapping("/api/member")//공통적으로 만들어준다.
public class MemberController {

  //스프링이 관리하도록 컨테이너에 등록해야한다...
  private final MemberService memberService;
  
  //api 연결 
  @PostMapping("/create")
  public ResponseEntity<?> createMember(@RequestBody MemberCreate request){
    memberService.createMember(request);
    return ResponseEntity.ok().body("성공");
  } 
}
