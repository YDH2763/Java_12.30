package day03;

public class Ex07_ForSum {

	public static void main(String[] args) {
		/*1부터 10까지의 함을 구하는 코드를 작성*/
		
		int j=0;	//초기값(반복문 안에서 선언하면 x)
		for(int i=0;i<=10;i++) {	//j에 i를 10까지 순차적으로 더함
			j=j+i;
			
			if(i==10){
				System.out.println("1부터 10까지의 합은"+j+"입니다.");
			}
		}
		j=0;
		for(int i=0;i<=10;i++) {
			if(i%2==0) {
				j=j+i;
			}
			
			if(i==10){
				System.out.println("1부터 10까지의 짝수의 합은"+j+"입니다.");
			}
		}

	}

}
