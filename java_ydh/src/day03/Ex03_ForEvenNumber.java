package day03;

public class Ex03_ForEvenNumber {

	public static void main(String[] args) {
		/*10이하의 짝수를 출력하는 코드를 작성*/
		//1~10사이의 짝수들만 출력
		//2~10사이의 짝수들만 출력
		
		for(int i=1;i<=10;i++) {
			if(i%2==0) {
				System.out.print(i+ ", ");
				if(i==10) {
					System.out.println("");
					System.out.println("------ ");
				}
			}
		}
		
		for(int j=2;j<=10;j=j+2) {
			System.out.print(j+ ", ");
			if(j==10) {
				System.out.println("");
				System.out.println("------ ");
			}
		}
		
		for(int k=1;k<=5;k++) {
			System.out.print((k*2)+ ", ");
			if(k==5) {
				System.out.println("");
				System.out.println("------ ");
			}

		}
	}

}
