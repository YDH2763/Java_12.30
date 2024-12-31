package day02;
import java.util.Scanner;
public class Ex08_IfGrade {

	public static void main(String[] args) {
		// 성적이 주어지면 주어진 성적에 맞는 학점을 출력하는 코드를 작성
		/*A:90~100
		 *B:80~89
		 *C:70~79
		 *D:60~69
		 *F:0~59
		 *그 외: 0보다 작거나 100보다 큰경우 
		 * */
		Scanner num = new Scanner(System.in);	//입력 가능하게 해주는 매소드
		String name;	//문자열 선언
		double g; 	//정수,실수 선언
		name = num.next();	//next():문자 입력
		g=num.nextDouble();	//(Int)정수, (Double)실수 입력
		System.out.println("이름 : "+name);
		
		if(g>=90 && g<=100){
			System.out.println(g+" = A학점");
		}
		else if(g>=80 &&g<90) {
			System.out.println(g+" = B학점");
		}
		else if(g>=70 &&g<80) {
			System.out.println(g+" = C학점");
		}
		else if(g>=60 &&g<70) {
			System.out.println(g+" = D학점");
		}
		else if(g>=0 &&g<60) {
			System.out.println(g+" = F학점");
		}
		else {
			System.out.println("잘못 입력하였습니다.");
		}
		

	}

}
