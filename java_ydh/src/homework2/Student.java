package homework2;
import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Data
public class Student implements Serializable{
	
	private static final long serialVersionUID=0;
	private int grade;
	private int classNum;
	private String name;
	private int num;
	
	@Override
	public String toString() {
		return grade+"학년"+classNum+"반"+num+"번 "+name;
	}
	
	public void update(Student newstd) {
		if(newstd==null) {
			return;
		}
		grade =newstd.grade;
		classNum=newstd.classNum;
		num=newstd.num;
		name=newstd.name;
		
	}

	public void print() {
		// TODO Auto-generated method stub
		
	}

	
	//학생 개인의 성적을 담고 있는 배열
	//public List<Score> list;
	//equals를 오버라이딩, 학년, 반, 번호를 이용
	
}
