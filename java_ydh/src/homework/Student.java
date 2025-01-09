package homework;
import lombok.Data;

@Data
public class Student {
	private int grade;
	private int classNum;
	private String name;
	private int num;
	
	public Subject [] list;
}
