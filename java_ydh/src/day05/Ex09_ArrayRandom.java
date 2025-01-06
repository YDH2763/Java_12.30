package day05;
import java.util.Scanner;
import java.util.Random;
public class Ex09_ArrayRandom {

	public static void main(String[] args) {
		/*6개짜리 배열을 생성해서 1~10사이의 랜덤한 수를 저장하고 출력하는 코드를 작성
		 * 중복 허용*/
		Scanner number=new Scanner(System.in);
		Random random = new Random();
		System.out.println("범위를 정할 두 정수를 입력하세요.");
		int a=number.nextInt();
		int b=number.nextInt();
		
		System.out.println("다음 범위내 숫자에서 뽑을 수를 입력하세요.");
		
		int c=number.nextInt();
		int []d=new int[c];
		
		/*for(int i=0;i<=(c-1);i++) {
			int r=(int)(Math.random()*(b-a +1)+a);
			d[i]=r;
			System.out.println((i+1)+"번째에 배열에 들어간 정수는 "+d[i]+"입니다.");
		}*/
		createRandomArray(c,d,a,b);
				
	}
	/* 정수의 크기가 주어지면 최소값~최댓값 사이의 랜덤한 수를 생성하여 배열을 저장하고
	 * 저장된 배열을 반환하는 메소드를 만들어라
	 * 매개변수 : 최소값, 최댓값, 크기 =>int min, int max, int size
	 * 리턴타입 : 랜덤으로 생성된 배열
	 * 메소드명 : createRandomArray
	 * */
	public static int [] createRandomArray(int n1, int n2[], int n3, int n4){
		for(int i=0;i<=(n1-1);i++) {
			int r=(int)(Math.random()*(n4-n3 +1)+n3);
			n2[i] =r;
			System.out.println((i+1)+"번째에 배열에 들어간 정수는 "+n2[i]+"입니다.");
		}
		return n2;
		
	}
}
