package homework2;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Subject {
	private String subject;

	@Override
	public String toString() {
		return subject;
	}
	public void newSubject(String newsubject){
		this.subject=newsubject;
	}
	public void update(String subject) {
		this.subject=subject;
	}
}
