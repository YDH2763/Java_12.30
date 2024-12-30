package day01;

public class Ex11_OperetorPrefixIncrement {

	public static void main(String[] args) {
		int n1=10, n2 = 10;
		
		System.out.println("증가 전 n1(전위형):" + n1);
		System.out.println("증가 전 n2(후위형):" + n2);
		
		++n1;
		n2++;
		
		System.out.println("증가 후 n1(전위형):" + n1);
		System.out.println("증가 후 n2(후위형):" + n2);
		
		System.out.println("--------------");
		
		System.out.println("증가 전 n1(전위형):" + n1);
		System.out.println("증가 전 n2(후위형):" + n2);
		
		/*System.out.println("증가 중 n1(전위형):" + ++n1);
		System.out.println("증가 중 n2(후위형):" + n2++);*/
		n1++;
		System.out.println("증가 중 n1(전위형):" + n1);
		System.out.println("증가 중 n2(후위형):" + n2);
		n2++;
		
		System.out.println("증가 후 n1(전위형):" + n1);
		System.out.println("증가 후 n2(후위형):" + n2);
		

	}

}
