package homework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Score implements Serializable{
	private static final long serialVersionUID=0;
	private String  name;
	private String  sub;
	//private Subject subject;
	private int score;
	
	public void newScore(String newname,String newsub, int newscore){
		this.name=newname;
		this.sub=newsub;
		this.score=newscore;
	}

	@Override
	public String toString() {
		return name+"의 "+sub+"점수는 "+score+"점 입니다.";
	}

}
