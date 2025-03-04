package db.ex1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.ex1.model.vo.StudentVO;

public interface StudentDAO {

	List<StudentVO> selectStudentList();

	StudentVO selectStudent(int grade, int classNum, int num);
	
	StudentVO selectStudent2(@Param("std")StudentVO studentVO);

	boolean insertStudent(@Param("std")StudentVO std);

	boolean updateStudentName(@Param("std")StudentVO std);

	boolean deleteStudent(@Param("std")StudentVO std);

}