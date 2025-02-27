# TCL
# 트랜잭션 제어 언어
# 트랙잭션 : DB 상태를 변화 시키기 위해 수행하는 작업 단위
# START TRANSACTION/BRGIN/BEGIN WORK : 트랜젝션을 시작
# SAVEPOINT 저장명 : 임시로 저장할 위치를 지정
# ROLLBACK TO 저장명 : 저장명 전까지 상태로 되돌림
# ROLLBACK : 트랜잭션 시작 전까지 상태로 되돌림
# COMMIT : 지금까지 했던 작업을 반영함

SELECT * FROM SCORE;

START TRANSACTION;

UPDATE SCORE SET SC_SCORE = 90 WHERE SC_NUM = 1;

SAVEPOINT S1;

UPDATE SCORE SET SC_SCORE = 90 WHERE SC_NUM = 2;

SAVEPOINT S2;

# ROLLBACK TO S1;
ROLLBACK TO S2;
# ROLLBACK

COMMIT;
ROLLBACK;
