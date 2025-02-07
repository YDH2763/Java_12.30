package day23;

import lombok.Data;

public class Ex06_Class {

	public static void main(String[] args) {
		/*다음 예제에서 잘못된 부분을 찾아 수정하세요.
		 * 1.객체를 생성해서 전달하던지
		 * 2.프린트 메소드에 널값을 추가*/
		
		MyStudent std=new MyStudent(0,0,0,null);
		print(std);

	}
	
	public static void print(MyStudent std) {
		System.out.println(std.getGrade() + "학년");
		System.out.println(std.getClassNum()+"반");
		System.out.println(std.getNum()+"번호");
		System.out.println(std.getName());
	}

}

@Data
class MyStudent{
	
	int grade,classNum,num;
	String name;
	/**
	 * @param grade
	 * @param classNum
	 * @param num
	 * @param name
	 */
	public MyStudent(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	
	
}