package day05;

import java.util.Scanner;

public class Ex08_Array {

	public static void main(String[] args) {
		
		//3명의 학생의 국어 성적을 관리하기 위해서 배열을 선언,
		//콘솔을 통해 성적을 입력받고, 입력받은 성적을 출력하는 코드를 출력
		int studentcount =3;
		int[] korea = new int[studentcount];
		
		Scanner number = new Scanner(System.in);
		for(int i=0;i<=2;i++) {
		System.out.print("학생"+(i+1)+"국어 성적 입력 : ");
		korea[i]=number.nextInt();
		}
		
		for(int i=0;i<=2;i++) {
			System.out.println("학생"+(i+1)+"의 성적은 "+korea[i]+"입니다.");
		}
		//3학생의 평균을 구해라
		int a=0;
		for(int i=0;i<=studentcount-1;i++) {
			a+=korea[i];
			int b=a/i;
			System.out.println("학생들의 평균은 "+b+"점 입니다.");
		}
	}
}
