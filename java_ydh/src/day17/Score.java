package day17;
import java.util.List;
import java.util.Objects;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Score {
	
	private int strike;
	private int ball;
	private int out;
	private static int count;
	private int c;
	
	
	
	public Score(int strike, int ball, int out) {
		c=count++;
		this.strike=strike;
		this.ball =ball;
		this.out=out;
	}

	@Override
	public String toString() {
		return strike+"strike "+ball+"ball "+out+"out ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		return ball == other.ball && out == other.out && strike == other.strike;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ball, out, strike);
	}
	
	
	
}
