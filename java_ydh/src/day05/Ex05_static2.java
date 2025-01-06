package day05;

public class Ex05_static2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(합1(1,2));
		
		Ex05_static2 s= new Ex05_static2();
		System.out.println(s.합2(1,2));
		
		Ex10_Homework_1.main(args);

	}
	public static int 합1(int n1, int n2) {
		return n1+n2;
	}
	
	public int 합2(int n1, int n2) {
		return n1+n2;
	}
	
}

class StaticTest{
	
	int a;
	static int sa;
	
	public void printA() {
		a=10;
		sa=10;
	}
	
	public static void printSa() {
		//a=10; => 객체 변수는 정적 메소드에서 사용할 수 없음
		StaticTest st = new StaticTest();
		st.a=10;//객체 변수를 사용하기 위해 객체를 생성한 후 사용하면 가능
		sa=10;
	}
	
	public void test() {
		printA();
		printSa();
	}
	public static void staticTest() {
		//printA();=>객체 메소드는 정적 메소드에서 사용할 수 없음.
		StaticTest st = new StaticTest();
		st.printA();//객체 메소드를 사용하기 위해 객체를 생성한 후 사용하면 가능!
		printSa();
	}
}