package com.example.swcoaching.member;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
  private final JdbcOperations jdbcOperations;

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  public MemberRepositoryImpl(JdbcOperations jdbcOperations) {
    this.jdbcOperations = jdbcOperations;
  }

  @Override
  public Member findByUsername(String paramUsername) {
    return jdbcOperations.queryForObject(
            "SELECT id, username, name, remark  FROM member WHERE username = ?", (rs, rowNum) -> {
              long id = rs.getLong("id");
              String username = rs.getString("username");
              String name = rs.getString("name");
              String remark = rs.getString("remark");
              return new Member(id, username, null, name, remark);
            }, paramUsername);
  }
}