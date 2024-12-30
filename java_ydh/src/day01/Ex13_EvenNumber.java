package day01;

public class Ex13_EvenNumber {

	public static void main(String[] args) {
		//주어진 n1이 짝수면 true를 아니면 false가 출력 되도록 코드를 작성하세요.
		int n1=3;
		//n1을 2로 나뉘었을때 나머지 0과 같다.
		
		boolean isEven =n1%2 == 0;
		System.out.println(n1 + "는 짝수인가?"+ isEven);

	}

}
