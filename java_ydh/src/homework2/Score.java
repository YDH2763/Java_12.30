package homework2;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Score {
private static final long serialVersionUID = 0;
	
	private Subject subject;
	private int score;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return subject + " " + score + "점";
	}
	
}
