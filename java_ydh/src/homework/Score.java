package homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Score {
	private String name;
	private String sub;
	private int score;
	
	public void newScore(String newsub, int newscore){
		this.sub=newsub;
		this.score=newscore;
	}

	@Override
	public String toString() {
		return name+"의 "+sub+"점수는 "+score+"점 입니다.";
	}
	

}
