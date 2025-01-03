package day04;
import java.util.Scanner;
public class Ex05_Method3 {

	public static void main(String[] args) {
		// nxn단을 출력하는 코드를 작성(메소드 이용)
		Scanner number=new Scanner(System.in);
		int n=number.nextInt();
		if(n>=1) {
			int a=MultipleTable(n);
		}
		else {
			System.out.println("잘못 입력하였습니다.");
			System.out.println("다시 실행해서 입력해주세요.");
		}
		
	}
	
	public static int MultipleTable(int n1) {
		int MultipleTable=0;
		for(int i=1;i<=n1;i++) {
			System.out.println(i+"단");
			for(int j=1;j<=n1;j++) {
				System.out.println(i+"x"+j+"="+(i*j));
				if(j==n1) {
					System.out.println("---------");
				}
			}
		}
		return MultipleTable;
	}

}
