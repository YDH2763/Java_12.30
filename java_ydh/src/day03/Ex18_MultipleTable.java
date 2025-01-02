package day03;
import java.util.Scanner;
public class Ex18_MultipleTable {

	public static void main(String[] args) {
		
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
