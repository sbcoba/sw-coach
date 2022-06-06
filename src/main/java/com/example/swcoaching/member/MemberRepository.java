package com.example.swcoaching.member;

public interface MemberRepository {
  Member findByUsername(String username);
}