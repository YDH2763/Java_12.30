SELECT
 CONCAT(FP_YEAR, DE_NAME_NUM, LPAD(RANK() OVER(ORDER BY FP_NAME, FP_RES_NUM), 3, "0")) AS ST_NUM, 
 FP_NAME
 FP_RES_NUM,
 FP_PHONE,
 FP_YEAR
FROM
	FINAL_PASS
JOIN
	DEPARTMENT ON FP_DE_NUM = DE_NUM
WHERE
	FP_DE_NUM = "COM" AND FP_YEAR = YEAR(NOW());