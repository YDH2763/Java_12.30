package homework2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class StudentManager {
	
	private List<Student> list;
	
	public StudentManager(List<Student> list) {
		if(list==null) {
			this.list= new ArrayList<Student>();
		}
		else {
			this.list=list;
		}
	}
	
	public StudentManager() {
		this.list=new ArrayList<Student>();
	}
	
	public boolean inputStudent(Student std) {
		if(std==null||list==null) {
			return false;
		}
		if(list.contains(std)) {
			return false;
		}
		return list.add(std);
	}
	
	public Student getStudent(Student std) {
		int index=list.indexOf(std);
		return index < 0? null:list.get(index);
	}
	
	public boolean updateStudent(Student selStd, Student newStd) {
		if(selStd ==null ||newStd ==null) {
			return false;
		}
		if(!list.contains(newStd)) {
			return false;
		}
		Student temp =getStudent(newStd);
		//수정될 정보가 없가나 이전 학생 정보이면
		if(temp==null||temp==selStd) {
			getStudent(selStd).update(newStd);
			return true;
		}
		return false;
	}
	
	public boolean deleteStudent(Student Std) {
		if(Std ==null ||list ==null) {
			return false;
		}
		return list.remove(Std);
	}

	public void printStudent(Student std) {
		if(std==null) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}
		if(list==null) {
			System.out.println("학생 정보가 없습니다.");
			return;
		}
		Student temp =getStudent(std);
		if(temp==null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		temp.print();
	}

	public boolean insertScore(Student std, Score subjectscore) {
		if(list==null||std==null||subjectscore ==null) {
			return false;
		}
		std=getStudent(std);
		if(std==null) {
			return false;
		}
		return std.insertScore(subjectscore);
	}
	
	public boolean updataScore(Student std, Subject subject, Score subjectscore) {
		if(list==null&&std==null&subject==null) {
			return false;
		}
		std=getStudent(std);
		if(std==null) {
			return false;
		}
		return std.updateScore(subject,subjectscore);
	}
	
	public boolean deleteScore(Student std, Subject subject) {
		
		return std.deleteScore(subject);
	}
	
	public void printScore(Student std,Subject subject) {
		if(std==null||subject==null||list==null) {
			System.out.println("출력할 수 없습니다.");
			return;
		}
		std=getStudent(std);
		if(std==null) {
			System.out.println("출력할 수 없습니다.");
			return;
		}
		return;
	}

}
