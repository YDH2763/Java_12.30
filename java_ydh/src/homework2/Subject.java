package homework2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject implements Serializable{
	private static final long serialVersionUID=0;
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

