package day06;
import java.util.Arrays;
import java.util.Scanner;
public class Ex08_ReverseNumber {

	public static void main(String[] args) {
		//4자리의 정수를 입력받아 입력받은 정수를 역순으로 출력하는 코드를 작성하세요.
		Scanner number=new Scanner(System.in);
		/*System.out.println("다음 배열의 크기를 입력하세요.");
		int n=number.nextInt();*/
		int []a=new int[4];
		
		for(int i=0;i<4;i++) {
			System.out.println((i+1)+"번째 열에 들어갈 수를 입력하세요.");
			int num=number.nextInt();
			a[i]=num;
		}
		
		System.out.print("배열a에 배치된 수:");
		print(a);
		System.out.println(" ");
		//System.out.println(Arrays.toString(a));
		
		int t=0, s=0;
		t=a[0];
		s=a[1];
		a[0]=a[3];
		a[1]=a[2];
		a[2]=s;
		a[3]=t;
		System.out.println("배열a가 역순으로 배치된 수:");
		System.out.println(Arrays.toString(a));
		
		
		
		

	}
	public static void print(int []n1) {
		for(int i=0;i<n1.length;i++) {
			System.out.print(n1[i]+" ");
		}
		System.out.println();
	}
}
