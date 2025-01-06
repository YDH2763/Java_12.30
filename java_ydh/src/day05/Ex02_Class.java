package day05;

public class Ex02_Class {

	public static void main(String[] args) {
		String name="주호민";
		int count=100;
		
		System.out.println("이름"+name+"-"+count+"회");
		Record1(name,count);
		System.out.println("이름"+name+"-"+count+"회");
		
		System.out.println("---------------------");
		
		Record r1 =new Record(name,count);
		Record2 (r1);
		r1.print();
		
		

	}
	public static void Record1(String name, int count) {
		name ="이병권";
		count =1;
	}
	public static void Record2(Record r1) {
		r1.setName("이병권");
		r1.setCount(2);
	}
	
}

class Record{
	//맴버변수, 필드
	private int count;
	private String name;
	//메소드 : 기능	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println("이름 : " +name+"-"+count+"회");
	}
	//생성자
	public Record(String name1, int count1) {
		name = name1;
		count =count1;
	}
	public Record() {
		
		this("이병권", 100);
		//name ="이병권";
		//count=100;
	}
}
