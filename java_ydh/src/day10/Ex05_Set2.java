package day10;
import java.util.Random;
import java.util.HashSet;
public class Ex05_Set2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*1에서 9사이의 랜덤한 수를 생성하여 중복되지 않게 3개 만드는 코드를 작성
		 *  */
		Random random=new Random();
		HashSet<Integer> set = new HashSet<Integer>();
		
		int a=1;
		int b=9;
		
		while(set.size()<3) {
			int r=(int)(Math.random()*(b-a+1)+a);
			set.add(r);
		}
		
		System.out.println(set);
		
		
		
	}

}
