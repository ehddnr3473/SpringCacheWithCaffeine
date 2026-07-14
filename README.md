# SpringCacheWithCaffeine

# 개요
공통 코드와 같이 조회는 빈번하지만 수정 빈도가 낮은 데이터를 Caffeine 라이브러리를 사용해서 캐시하는 예시

# DDL

```sql
-- 그룹 코드 테이블
CREATE TABLE common_code_group (
  group_code VARCHAR(50) PRIMARY KEY,
  group_name VARCHAR(100) NOT NULL,
  description VARCHAR(500),
  use_yn CHAR(1) NOT NULL DEFAULT 'Y',
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 상세 코드 테이블
CREATE TABLE common_code_detail (
  group_code VARCHAR(50) NOT NULL,
  code VARCHAR(50) NOT NULL,
  code_name VARCHAR(100) NOT NULL,
  description VARCHAR(500),
  sort_order INT NOT NULL DEFAULT 0,
  use_yn CHAR(1) NOT NULL DEFAULT 'Y',
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (group_code, code),
  FOREIGN KEY (group_code) REFERENCES common_code_group(group_code)
);
```
