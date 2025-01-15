package homework;
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
	
	
}
