package day05;
import java.util.Scanner;
import java.util.Random;
public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		/*	최솟값~최댓닶 사이의 중복되지 않은 랜덤한 수 n개를 배열에 저장하는 코드를 작성
		 * 
		 * */
		Scanner number =new Scanner(System.in);
		
		System.out.println("범위를 정할 두 정수를 입력하세요.");
		int a=number.nextInt();
		int b=number.nextInt();
		
		System.out.println("다음 범위내 숫자에서 뽑을 수를 입력하세요.");
		
		int c=number.nextInt();
		int []d=new int[c];
		boolean re;
		/*System.out.print("다음 정수를 입력하세요. : ");
		int n= number.nextInt();*/
		
		for(int i=0;i<=c-1;i++) {
			int r=(int)(Math.random()*(b-a +1)+a);
			re =false;
			d[i]=r;
			for(int j=0;j<d.length;j++) {
				if(d[j]==r) {
					
				}
			}
			
		}

	}
public static void printArray(int []arr) {
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+"");
	}
	System.out.println();
}

public static int [] createRandomArray(int n1, int n2, int n3){
	if(n3<=0) {
		return null;
	}
	int []arr =new int[n3];
	int count = 0;
	while(count < arr.length) {
		int r=(int)(Math.random()*(n2-n1 +1)+n1);
		
		if((n3, r)) {
			continue;
		}
		arr[count++]=count++;
	}
	return arr;
}
}
