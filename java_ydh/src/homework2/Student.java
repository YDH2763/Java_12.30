package homework2;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Data
 class Student {
	private int grade;
	private int classNum;
	private String name;
	private int num;
	
	@Override
	public String toString() {
		return grade+"학년"+classNum+"반"+num+"번 "+name;
	}
	
	public void update(int newgrade, int newclassNum, int newnum, String newname) {
		this.grade =newgrade;
		this.classNum =newclassNum;
		this.num =newnum;
		this.name =newname;
		
	}
	//학생 개인의 성적을 담고 있는 배열
	//public List<Score> list;
	//equals를 오버라이딩, 학년, 반, 번호를 이용
	
}
