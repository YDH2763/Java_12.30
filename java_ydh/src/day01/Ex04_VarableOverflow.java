package day01;

public class Ex04_VarableOverflow {

	public static void main(String[] args) {
		byte n1=127;
		n1++;//n1에 1을 증가
		//오버플로우
		System.out.println(n1); //byte로 표현 가능한 숫자에 1을 더하면 128이 아닌 -128이 나온다
		
		byte n2=-128;
		n2--;//n2에 1을 감소
		//언더플로우
		System.out.println(n2);//byte로 표현 가능한 가장 작은 숫자에 1을 빼면 -129가 아닌 127이 나온다
		
	}

}
