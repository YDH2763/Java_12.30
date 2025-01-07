package day06;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Ex06_ArraySort {

	public static void main(String[] args) {
		Scanner number=new Scanner(System.in);
		System.out.println("다음'배열1'의 크기를 입력하세요.");
		int n=number.nextInt();
		System.out.println("다음'배열2'의 크기를 입력하세요.");
		int n1=number.nextInt();
		//int n2=number.nextInt();
		int []array=new int[n];
		
		Enter(n,array);
		Out(array);
		
		for(int i=0;i<array.length-1;i++) {
			for(int j=0;j<array.length-1;j++) {
				if(array[j]<array[j+1]) {
					int t=array[j];
					array[j]=array[j+1];
					array[j+1]=t;
				}
			}
		}
		Ex05_EnhancedFor.print2(array);
		
		int [] array2= new int[n1] ;
		Enter(n1,array2);
		/*Array.sort(배열) : 오름차순으로 정렬*/
		Arrays.sort(array2);
		//Arrays.toString(배열): 배열을 문자열로 변환
		System.out.println(Arrays.toString(array2));
		
		Integer [] array3= {100,16,49,25,9,1,4,36,64,81};
		/*배열의 내림차순은 기본 자료형으로는 제공이 안됨.
		 * Integer 배열을 활용.
		 * Arrays.sort(배열,Collections.reverseOrder())*/
		Arrays.sort(array3, Collections.reverseOrder());
		System.out.println(Arrays.toString(array3));
		
	}
	public static void Enter(int n1, int n2[]) {
		for(int i=0;i<=n1-1;i++) {
			Scanner number=new Scanner(System.in);
			System.out.println((i+1)+"번째 열에 들어갈 수를 입력하세요.");
			int num=number.nextInt();
			n2[i]=num;
		}
	}
	public static void Out(int n1[]) {
		for(int i=0;i<n1.length;i++) {
			System.out.print(n1[i]+", ");
		}
		System.out.println("");
		System.out.println("--------------------");
	}
}
