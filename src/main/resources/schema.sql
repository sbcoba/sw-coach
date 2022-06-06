DROP TABLE IF EXISTS member;
CREATE TABLE member (
    id       BIGINT AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL COMMENT '사용자ID',
    password VARCHAR(200) NOT NULL COMMENT '패스워드',
    name     VARCHAR(100) NULL COMMENT '사용자 이름',
    remark   VARCHAR(500) NULL COMMENT '사용자 기타 정보',
    CONSTRAINT member_id_pk
        PRIMARY KEY (id)
);

CREATE UNIQUE INDEX member_id_unique_idx ON member(id);