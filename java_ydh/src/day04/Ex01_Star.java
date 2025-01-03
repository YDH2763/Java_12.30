package day04;
import java.util.Scanner;
public class Ex01_Star {

	public static void main(String[] args) {
		Scanner number =new Scanner(System.in);
		int n=number.nextInt();
		
		for(int i=1;i<=n;i++) { //역순으로 별 배치
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1;i<=n;i++){	//나무 만들기
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=(2*i-1);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=1;i<=n;i++) {	//
			for(int j=1;j<=n-i;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.print(" ");
			for(int k=1;k<=i-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
