package day06;
import java.util.Scanner;
public class Ex01_Swap {

	public static void main(String[] args) {
		Scanner number=new Scanner(System.in);
		
		System.out.print("다음 정수를 입력하세요. : ");
		int a=number.nextInt();
		System.out.print(", ");
		int b=number.nextInt();
		System.out.println(" ");
		
		int c=a;
		a=b;
		b=c;
		
		System.out.println(a+", "+b);

	}

}
