package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.SubjectVO;

public interface SubjectDAO {
	List<SubjectVO> selectSubjectList();

	SubjectVO selectSubject(@Param("grade")int grade, @Param("semester")int semester);
}
