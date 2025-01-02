package day03;

public class Ex19_NestingPrimeNumber {

	public static void main(String[] args) {
		// 100이하의 소수를 출력하는 코드를 작성하세요.
		int n=4;
		int c=0;
		for(int i=1;i<=100;i++) {
			for(int j=2;j<=100;j++) {
				if(j%i==0) {
				}
			}
			if(c==2) {
				System.out.println(c+", ");
			}
			c++;
		}

	}

}
