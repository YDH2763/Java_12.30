package day02;
import java.util.Scanner;

public class Ex19_ForMultipleTable {

	public static void main(String[] args) {
		// nxn단을 출력하는 코드를 작성하세요.
		//반복횟수 : i는 1부터 9까지 1씩 증가
		//규칙성 : 2 x i = 2*1를 출력
		//반복문 종료 후 : 없음
		Scanner number = new Scanner(System.in);
		int n=number.nextInt();
		
		if(n>=1) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					System.out.println(i+"x"+j+"="+(i*j));
					if(j==n) {
						System.out.println("---------");
					}
				}
			}
		}
		else {
			System.out.println("다시 실행하여 정수를 입력해주세요.");
		}
	}

}
