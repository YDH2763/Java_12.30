USE OMOK;
INSERT INTO `SCORE`(S_POSITION, S_COUNT, S_WIN, S_LOSE, S_DRAW, S_U_ID)
VALUES("BLACK", 10, 7, 2, 1, "dbehdgns12345"),("WHITE", 10, 4, 5, 1, "dbehdgns12345");

SELECT COUNT(*) AS "dbehdgns12345의 백팀 게임 진행 횟수 " FROM SCORE WHERE S_POSITION="WHITE";
# 전체 승률 ()

# 흑팀 승률 ()

# 흑팀 승률 ()










