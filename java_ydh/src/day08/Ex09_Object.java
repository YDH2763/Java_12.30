package day08;

import java.util.Objects;

public class Ex09_Object {

	public static void main(String[] args) {
		Point p=new Point();
		/*println은 매개변수가 클래스의 객체이면 객체의 toString을 호출해서 출력
		 * =>모든 클래스는 Object 클래스를 상속 받음=>Object 클래스에서 물려받은 toString을
		 * 가지고 있기 때문에
		 * */
		System.out.println(p);
		System.out.println(p.toString());
		
		Account item=new Account("수입", "월급", "1월 월급", 0, "2025-01-01");
		System.out.println(item);
		
		Student2 std1= new Student2(1,1,1,"이병권","국어",100);
		Student2 std2= new Student2(1,1,2,"주호민","국어",100);
		Student2 std3= new Student2(1,1,1,"김단군","국어",90);
		
		Student2 std4=(Student2)std1.clone();

	}
	
	public void println(Object object) {
		System.out.println(object.toString());
	}
	
}

class Point{
	private int x,y;

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
	
@AllArgsConstructor
@ToString
class Student2 implements Cloneable{
	 int grade;
	 int classNum;
	 String name;
	 String subject;
	 int num;
	
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getEnclosingInstance().hashCode();
		result = prime * result + Objects.hash(classNum, grade, num);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student2 other = (Student2) obj;
		if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
			return false;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	private Point getEnclosingInstance() {
		return Point.this;
	}
	 
	 
}
}