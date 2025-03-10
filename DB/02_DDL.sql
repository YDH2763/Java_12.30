# CREATE : 생성
# ALTER : 수정
# DROP : 삭제
# TRUNCATE : 테이블을 초기화

# 데이터베이스 생성
# CREATE DATABASE [IF NOT EXISTS] DB명
# CREATE SCHEMA [IF NOT EXISTS] DB명
# IF NOT EXISTS가 없으면 있는 DB를 생성하려는 경우 쿼리에 에러가 발생
# => 이후 쿼리를 실행할 수 없음
CREATE DATABASE IF NOT EXISTS STUDENT;

# 데이터베이스 삭제
# DROP DATABASE [IF EXISTS] DB명
# DROP SCHEMA [IF EXISTS] DB명
# DROP DATABASE IF EXISTS STUDENT; 

# 데이터베이스 문자 집합을 설정
# ALTER SCHEMA DB명 DEFAULT CHARACTER SET 새CHARACTER DEFAULT COLLATE 새COLLATE;

# 테이블 생성
/*
CREATE TABLE [IF NOT EXSITS] 테이블명(
	컬럼명 타입 [ZEROFILL] [UNIQUE] [NOT NULL] [DEFAUT 값] [PRIMARY KEY] [AUTO_INCREMENT],
    ...,
    [ CONSTRAINT 제약조건명 PRIMARY KEY(컬럼명),]
    [ PRIMARY KEY(컬럼명),]
	[ CONSTRAINT 제약조건명 FOREIGN KEY(컬럼명), REFERENCES 참조테이블명(기본키명),]
    [ FOREIGN KEY(컬럼명), REFERENCES 참조테이블명(기본키명),]
    [ CONSTRAINT CHECI(논리식)]
    [ CHECK(논리식)]
);

ZEROFILL
 - 앞에 0으로 채울때 사용
 - 5자리 숫자로 정하고, 1을 저장했을 때 앞에 4자리를 0으로 채움
UNIQUE
 - 컬럼들의 값들이 중복되면 안되는 경우 지정.(보퐅 대체키에)
NOT NULL
 - 컬럼이 NULL값을 가지면 안될 때 사용
PRIMARY KEY
 - 기본키
 - 제약 조건으로 설정할 수도 있지만 컬럼명 앞에 지정할 수 있다
 - NOT NULL + UNIQUE 
AUTO_INCREMENT
 - 기본키에만 가능, 정수형 속성에 지정 가능
 - 데이터를 추가할 때 기본키에 값을 지정하지 않으면 자동으로 1증가되어서 추가 됨
*/

USE STUDENT;
CREATE TABLE IF NOT EXISTS STUDENT(
	ST_KEY INT PRIMARY KEY AUTO_INCREMENT,
    ST_GRADE INT NOT NULL DEFAULT 1,
    ST_CLASS INT NOT NULL DEFAULT 1,
    ST_NUM INT NOT NULL DEFAULT 1,
    ST_NAME VARCHAR(20) NOT NULL,
    CHECK(ST_GRADE >=1),
    CHECK(ST_CLASS >=1),
    CHECK(ST_NUM >=1)
);

# 테이블 삭제
# DROP TABLE [IF EXISTS] 테이블명;
# DROP TABLE STUDENT;

# 테이블 수정 - 컬럼 추가
# ALTER TABLE 테이블명 ADD 컬럼명 타입[...];
ALTER TABLE STUDENT ADD ST_TEST DATETIME DEFAULT CURRENT_TIMESTAMP;

# 테이블 수정 - 컬럼 수정
# ALTER TABLE 테이블명 CHANGE 기존컬럼명 새컬럼명 타입[...];
ALTER TABLE STUDENT CHANGE ST_TEST TEST CHAR(3) NOT NULL;

# 테이블 수정 - 컬럼 삭제
# ALTER TABLE 테이블명 DROP 컬럼명;
ALTER TABLE STUDENT DROP TEST;

# 등록된 모든 제약 조건 확인
SELECT * FROM INFORMATION_SCHEMA.CHECK_CONSTRAINTS;

# 테이블 수정 - 제약 조건 추가
# ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건;
ALTER TABLE STUDENT ADD CONSTRAINT STUDENT_CHK4 CHECK(ST_NAME !=' ');

# 테이블 수정 - 제약 조건 삭제
# ALTER TABLE 테이블명 DROP 제약조건명;
ALTER TABLE STUDENT DROP STUDENT_CHK4;

# 테이블 초기화 : AUTO_INCREMENT 값을 1로 초기화 및 데이터 제거
# TRUNCATE TABLE 테이블명;
 
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,1,"이병건"),(1,1,2,"주호민");
 
SELECT * FROM STUDENT.STUDENT;
 
INSERT INTO STUDENT.STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,3,"이병건"),(1,1,4,"주호민");
 
SELECT * FROM STUDENT.STUDENT;

TRUNCATE TABLE STUDENT.STUDENT;
-- DELETE FROM STUDENT.STUDENT;


 

 
 