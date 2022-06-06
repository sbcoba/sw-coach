package com.example.swcoaching.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MemberController {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final MemberRepository memberRepository;

  public MemberController(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @GetMapping("/member")
  public Member getHello(String username) {
    Member member = memberRepository.findByUsername(username);
    logger.info("Member: {}", member);
    return member;
  }
}