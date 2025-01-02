package day03;
import java.util.Random;
import java.util.Scanner;
public class Ex13_Random {

	public static void main(String[] args) {
		// (최소값~최댓값 사이의) 랜덤한 수를 생성하는 코드
		Scanner number = new Scanner(System.in);
		System.out.println("최솟값을 입력하세요");
		int min =number.nextInt();
		System.out.println("최댓값을 입력하세요");
		int max =number.nextInt();
		
		if(min>max) {
			System.out.println("최솟값이 최댓값보다 크게 측정되었습니다.");
			System.out.println("다시 입력해주세요.");
		}
		else {/*
				Math.random()는 0이상 1미만의 랜덤한 실수를 제공
		 		0<=r<1
		 		각 항에 (max-min+1)을 곱함
		 		0<=r*(max-min+1)<max-min+1
		 		각 항에 min을 더함
		 		min<=r*(max-min+1)+min<max+1
		 		*/
			//최솟값~최댓값 사이의 랜덤한 수를 생성
			int a=(int)(Math.random()*(max-min +1)+min);
			System.out.println(min+" 과 "+max+" 사이에서 "+a+"이(가) 출력되었습니다.");
			
		}
		int r=(int)(Math.random()*(max-min +1)+min);
		Random random = new Random();
		
		r =random.nextInt(max-min+1);//random.nextInt(a)는 0에서 a-1사이의 랜덤한 정수를 생성
		System.out.println(r);
	}

}
