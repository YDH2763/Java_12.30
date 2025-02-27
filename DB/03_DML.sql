# INSERT : 데이터 추가
# SELECT : 데이터 조회
# UPDATE : 데이터 수정
# DELETE : 데이터 삭제

# 데이터 추가
# INSERT INTO 테이블명 VALUE(값1, ...., 값N)
# - 값들 순서는 속성에 맞게 넣어 주어야 함.
# - 테이블명 대신 DB명.테이블명으로 해도 됨
# - 테이블명만 쓰려면 USE DB명으로 DB를 선택한 후에 사용(DB명.테이블명으로만 쓰면 선택된 DB와 상관없이 실행.)
# - 테이블명만 쓰면 선택된 DB에 따라 동작되지 않을 수 있음.
USE STUDENT;
INSERT INTO STUDENT VALUE(2, 1, 1, 1, "이병건");

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUE(값1, ..., 값N)
# - 일부 속성 값을 생략할 때 사용
# - 생략할 수 있는 속성들
#	1. NULL 허용인 속성들
#	2. NOT NULL이지만 DEFAULT를 이용하여 기본값을 지정한 속성들
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUE(1,1,2,"주호민");
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUE(3,"김영태");

# INSERT INTO 태이블명(속성1, ..., 속성N) VALUES(값1, ..., 값N), (값1, ..., 값N), ...;
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUES(4,"목진화"), (5," 박정민");

# INSERT INTO 태이블명 SELECT 속성1, ..., 속성N FROM 테이블명 WHERE 조건
# - 테이블에서 검색된 값을 이용하여 추가할 때 사용
# - 여기서 값1, 값2,... 들은 저장된 값이고, 속성A는 검색 결과 값


# 데이터 수정
# UPDATE 테이블명 SET 속성1 = 값1, ..., 값N WHERE 조건
# 조건에서 같다는 =, 같지않다는 != 또는 <>
# NULL과 같다는 IS NULL, NULL과 같지 않다는 IS NOT NULL
# 1학년 1반 1번 학생의 이름을 이말년으로 수정하는 쿼리
UPDATE STUDENT SET ST_NAME = "이말년" WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1;

# 데이터 삭제
# DELETE FROM 테이블 명 WHERE 조건;
# 1학년 1반 2벙의 학생의 데이터를 삭제하는 쿼리
DELETE FROM STUDENT
WHERE
	ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 2;

# 학생들 샘플 데이터 추가
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUES
(2,1,1,"김기열"),(2,1,2,"김의중"),(2,1,3,"김정현"),
(2,1,4,"박재성"),(2,1,5,"목진화"),(2,1,6,"이병건"),
(2,1,7,"이세화"),(2,1,8,"진용원"),(2,1,9,"주호민");
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUES
(3,1,1,"김기열"),(3,2,1,"김의중"),(3,3,1,"김정현"),
(3,4,1,"박재성"),(3,5,1,"목진화"),(3,6,1,"이병건"),
(3,7,1,"이세화"),(3,8,1,"진용원"),(3,9,1,"주호민");

# 과목 샘플 데이터르 추가
INSERT INTO STUDENT.SUBJECT(SJ_GRADE, SJ_SEMESTER, SJ_NAME) VALUES
(1,1,"국어"),(1,1,"영어"),(1,1,"수학"),
(1,2,"국어"),(1,2,"영어"),(1,2,"수학"),
(2,1,"국어"),(2,1,"영어"),(2,1,"수학"),
(2,2,"국어"),(2,2,"영어"),(2,2,"수학"),
(3,1,"국어"),(3,1,"영어"),(3,1,"수학"),
(3,2,"국어"),(3,2,"영어"),(3,2,"수학");

# 성적 샘플 데이터를 추가
INSERT INTO STUDENT.SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES
(2, 1, 100), (2, 2, 100), (2, 3, 100), # 1학년 1반 1번 학생 1학년 1학기 국영수 성적
(4, 1, 90), (4, 2, 80), (4, 3, 70), # 1학년 1반 3번 학생 1학년 1학기 국영수 성적
(5, 1, 90), (5, 2, 10), (5, 3, 100), # 1학년 1반 4번 학생 1학년 1학기 국영수 성적
(6, 1, 90), (6, 2, 100), (6, 3, 10), # 1학년 1반 5번 학생 1학년 1학기 국영수 성적
(7, 4, 100), (7, 5, 0), (7, 6, 100), # 2학년 1반 1번 학생 1학년 2학기 국영수 성적;
(8, 4, 50), (8, 5, 30), (8, 6, 80), # 2학년 1반 2번 학생 1학년 2학기 국영수 성적;
(9, 4, 40), (9, 5, 55), (9, 6, 99), # 2학년 1반 3번 학생 1학년 2학기 국영수 성적;
(10, 4, 10), (10, 5, 84), (10, 6, 55), # 2학년 1반 4번 학생 1학년 2학기 국영수 성적;
(11, 4, 75), (11, 5, 66), (11, 6, 74), # 2학년 1반 5번 학생 1학년 2학기 국영수 성적;
(12, 4, 32), (12, 5, 44), (12, 6, 65), # 2학년 1반 6번 학생 1학년 2학기 국영수 성적;
(13, 4, 77), (13, 5, 88), (13, 6, 55), # 2학년 1반 7번 학생 1학년 2학기 국영수 성적;
(14, 4, 88), (14, 5, 12), (14, 6, 12), # 2학년 1반 8번 학생 1학년 2학기 국영수 성적;
(15, 4, 0), (15, 5, 0), (15, 6, 0), # 2학년 1반 9번 학생 1학년 2학기 국영수 성적;
(16, 7, 100), (16, 8, 100), (16, 9, 100); # 3학년 1반 1번 학생 2학년 1학기 국영수 성적;

# 1학년 1반 1번의 1학년 2학기 국어 성적을 100으로 추가할 때 쿼리
SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1;
SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어";
SELECT ST_KEY,SJ_NUM
FROM STUDENT 
JOIN SUBJECT
WHERE 
	ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1
    AND SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어";
    
SELECT ST_KEY,SJ_NUM
FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;
# 1학년 1반 1번의 1학년 2학기 국어 성적을 100으로 추가할 때 쿼리
INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE)
SELECT ST_KEY,SJ_NUM, 100
	FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
	JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;
    
    