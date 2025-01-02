package day03;
import java.util.Scanner;
public class Ex01_Test {

	public static void main(String[] args) {
		/*3명의 학생의 국어 성적을 입력받아 총점과 평균을 구하는 코드를 적어라*/
		
		Scanner score =new Scanner(System.in);
		
		System.out.println("다음 A학생의 국어 점수를 입력하세요.");
		int studentA=score.nextInt();
		System.out.println("다음 B학생의 국어 점수를 입력하세요.");
		int studentB=score.nextInt();
		System.out.println("다음 C학생의 국어 점수를 입력하세요.");
		int studentC=score.nextInt();
		
		int a=studentA+studentB+studentC;
		double b=a/3.0;
		
		if(studentA>=0 &&studentA<=100 && studentB>=0 && studentB<=100 && studentC>=0 &&studentC<=100 ) {
			System.out.println("세 학생의 국어 점수의 총합은 " + a +"점 입니다.");
			System.out.println("세 학생의 국어 점수의 평균은 약" + b +"점 입니다.");
		}
		else {
			System.out.println("세 학생들의 점수중 1명 이상이 잘못 입력하였습니다.");
		}
	}

}
