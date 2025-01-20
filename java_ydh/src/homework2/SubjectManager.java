package homework2;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SubjectManager {
	
	private List<Subject> list;
	
	public SubjectManager(List<Subject> list) {
		if(list==null){
			this.list=new ArrayList<Subject>();
		}
		else {
			this.list=list;	
		}
	}
	
	public SubjectManager() {
		this.list=new ArrayList<Subject>();
	}
	
	public boolean insertSubject(Subject subject) {
		if(subject == null|| list==null) {
			return false;
		}
		if(list.contains(subject)) {
			return false;
		}
		return true;
	}

	public boolean updateSubject(Subject subject, Subject newsubject) {
		if(list==null||subject==null||newsubject==null) {
			return false;
		}
		//등록 안된 과목을 수정하려고 함
		if(list.contains(subject)) {
			return false;
		}
		//수정할 과목이 등록되지 않으면 수정
		if(list.contains(newsubject)) {
			list.add(newsubject);
			list.remove(subject);
			return true;
		}
		return true;
	}

	public boolean contains(Subject subject) {
		
		return list!=null && list.contains(subject);
	}

	public boolean deleteSubject(Subject subject) {
		if(list==null) {
			return false;
		}
		return list.remove(subject);
	}

	public void printSubject() {
		if(list==null ||list.size()==0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		}
		for(Subject temp:list) {
			System.out.println(temp);
		}
		
	}
}
