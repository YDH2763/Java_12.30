package day08;

public class Ex05_Super {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p =new Parent("이병권");
		p.print();
		System.out.println("-----------");
		Child c= new Child("주호민");
		c.print();
		
		
	}

}

class Parent{
	String name;

	public Parent(String name) {
		this.name = name;
	}
	public Parent() {
		
	}
	public void print() {
		System.out.println("출력합니다.");
	}
}
class Child extends Parent{
	
	String type;
	
	public Child() {
		super("");
		type = "";	//
	}
	
	public Child(String name) {
		super(name);
		type = "일반";	//
	}
	
	@Override
	public void print() {
		//출력합니다.
		//자식 클래스에서 출력합니다.
		super.print();
		System.out.println(name+" : "+type);
		
	}
}