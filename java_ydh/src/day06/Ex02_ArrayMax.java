package day06;
import java.util.Scanner;
public class Ex02_ArrayMax {

	public static void main(String[] args) {
		Scanner number=new Scanner(System.in);
		System.out.println("다음 배열의 크기를 입력하세요.");
		int n=number.nextInt();
		int []a=new int[n];
		
		for(int i=0;i<=n-1;i++) {
			System.out.println((i+1)+"번째 열에 들어갈 수를 입력하세요.");
			int b=number.nextInt();
			a[i]=b;
		}
		
		System.out.print("배열"+n+"에 배치된 수:");
		for(int i=0;i<=n-1;i++) {
			System.out.print(a[i]);
			System.out.print(",");
		}
		
		System.out.println(" ");
		int c=0;
		
		for(int i=0;i<n;i++) {
			if(c<a[i]) {
				c=a[i];
			}
		}
		System.out.println("배열에 배치된 숫자중 가장 큰 숫자 : "+c);

	}

}
