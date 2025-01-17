package homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
	
	private int grade;
	private int term;
	private String subject;
	
	@Override
	public String toString() {
		return grade+"학년 "+term+"학기 "+"과목 : "+subject;
	}
	
	public void update(int newgrade, int newterm, String subject) {
		this.grade =newgrade;
		this.term =newterm;
		this.subject =subject;
		
	}
	
	
}
