package homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
	private String subject;

	@Override
	public String toString() {
		return subject+", ";
	}
	public void newSubject(String newsubject){
		this.subject=newsubject;
	}
	
}
