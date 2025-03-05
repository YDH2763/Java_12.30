USE OMOK;
INSERT INTO `SCORE`(S_POSITION, S_COUNT, S_WIN, S_LOSE, S_DRAW, S_U_ID)
VALUES("BLACK", 10, 7, 2, 1, "dbehdgns12345"),("WHITE", 10, 4, 5, 1, "dbehdgns12345"),
		("BLACK", 12, 4, 7, 1, "dbehdrb12345"),("WHITE", 12, 5, 5, 2, "dbehdrb12345");

DROP VIEW `READ_SCORE`;
CREATE VIEW `READ_SCORE` AS 
	SELECT 
		S_NUM 전적번호, S_POSITION 진영, S_COUNT 게임횟수, S_WIN 승리, S_LOSE 패배, S_DRAW 무승부, S_U_ID 유저
	FROM
		SCORE;
        

SELECT * FROM SCORE;
# 유저 'dbehdgns12345'의 진영별 게임횟수
SELECT S_COUNT , S_POSITION  FROM SCORE WHERE S_U_ID ="dbehdgns12345";

# 유저 'dbehdgns12345'의 전체 게임 횟수
SELECT SUM(S_COUNT) 게임횟수 FROM SCORE WHERE S_U_ID ="dbehdgns12345";

# 유저 'dbehdgns12345'의 전체 승리 횟수
SELECT SUM(S_WIN) 승리 FROM SCORE WHERE S_U_ID ="dbehdgns12345";

# 유저 'dbehdgns12345'의 전체 패배 횟수
SELECT SUM(S_LOSE) 패배 FROM SCORE WHERE S_U_ID ="dbehdgns12345";

# 유저 'dbehdgns12345'의 전체 무승부 횟수
SELECT SUM(S_DRAW) 무승부 FROM SCORE WHERE S_U_ID ="dbehdgns12345";

# 유저 'dbehdgns12345'의 흑팀 승리 횟수
SELECT SUM(S_WIN) 승리 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "BLACK";

# 유저 'dbehdgns12345'의 흑팀 패배 횟수
SELECT SUM(S_LOSE) 패배 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "BLACK";

# 유저 'dbehdgns12345'의 흑팀 무승부 횟수
SELECT SUM(S_DRAW) 무승부 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "BLACK";

# 유저 'dbehdgns12345'의 백팀 승리 횟수
SELECT SUM(S_WIN) 승리 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "WHITE";

# 유저 'dbehdgns12345'의 백팀 패배 횟수
SELECT SUM(S_LOSE) 패배 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "WHITE";

# 유저 'dbehdgns12345'의 백팀 무승부 횟수
SELECT SUM(S_DRAW) 무승부 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "WHITE";


# 유저 'dbehdgns12345'의 전체 승률 ()
SELECT (SUM(S_WIN)/SUM(S_COUNT))*100 "전체 승률(%)", S_U_ID 유저  FROM SCORE WHERE S_U_ID ="dbehdgns12345";
# 유저 'dbehdgns12345'의 흑팀 승률 ()
SELECT (SUM(S_WIN)/SUM(S_COUNT))*100 "흑팀 승률(%)", S_U_ID 유저 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "BLACK";
# 유저 'dbehdgns12345'의 백팀 승률 ()
SELECT (SUM(S_WIN)/SUM(S_COUNT))*100 "백팀 승률(%)", S_U_ID 유저 FROM SCORE WHERE S_U_ID ="dbehdgns12345" AND S_POSITION = "WHITE";

SELECT 
    (SUM(S_WIN)/SUM(S_COUNT))*100 "전체 승률(%)",
    S_U_ID 유저
FROM SCORE WHERE S_U_ID="dbehdgns12345" ;

SELECT 
	S_POSITION "진영",
    ((S_WIN)/(S_COUNT))*100 "진영 승률(%)",
    S_U_ID 유저
FROM SCORE ;





0	112	18:10:49	SELECT 
  S_COUNT "전체 게임 횟수",
     S_WIN"전체 승리",
     S_LOSE "전체 패배",
     S_DRAW "전체 무승부",
     (SUM(S_WIN)/SUM(S_COUNT))*100 "전체 승률(%)",
     S_U_ID 유저
 FROM SCORE WHERE S_U_ID="dbehdgns12345"
 LIMIT 0, 1000	Error Code: 1140. In aggregated query without GROUP BY, expression #1 of SELECT list contains nonaggregated column 'omok.SCORE.S_COUNT'; this is incompatible with sql_mode=only_full_group_by	0.000 sec





