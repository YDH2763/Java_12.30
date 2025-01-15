package day12;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex01_FunctionInterface {

	public static void main(String[] args) {
		List<Person> list= new ArrayList<Person>();
		list.add(new Person("이병권","000101-3", 41));
		list.add(new Person("주호민","601212-1", 43));
		list.add(new Person("김단군","000101-1", 39));
		list.add(new Person("우원박","801111-2", 36));
		
		//'print'를 이용하여 사람들의 이름을 출력
		print(list,p->System.out.println(p.getName()));
		System.out.println("----------------------");
		//'print'를 이용하여 사람들의 전체 정보를 출력
		print(list,p->System.out.println(p));
		System.out.println("----------------------");
		//'print'를 이용하여 사람들의 주민번호를 출력
		print(list,p->System.out.println(p.getNum()));
		System.out.println("----------------------");
		//xx0101-x
		Person p=ramdomNumber(()->{
			int year=(int)(Math.random()*(99-0+1)+0);
			DecimalFormat df=new DecimalFormat("00");
			String yearStr = df.format(year);
			int gender =(int)(Math.random()*(4-1+1)+1);
			String num =yearStr+"0101-"+gender;
			return new Person("", num,0);
		});
		System.out.println(p);
		System.out.println("----------------------");
		//사람들의 이름을 출력
		printString(list,p1->p1.getName());
		System.out.println("----------------------");
		//사람들의 주민번호를 출력
		printString(list,p1->p1.getNum());
		System.out.println("----------------------");
		//모든 사람들의 나이를 1씩 증가
		replacePerson(list,p1->{
			p1.setYear(p1.getYear()+1);
			return p1;
		});
		print(list,p1->System.out.println(p1));
		System.out.println("----------------------");
		//이병권인 사람의 이름을 이말년이라고 변경
		replacePerson(list,p1->{
			if(p1.getName().equals("이병권")) {
				p1.setName("이말년");
			}
			return p1;
		});
		print(list,p1->System.out.println(p1));
		System.out.println("----------------------");
		
	}
	/* 'Consumer'는 매개변수가 있고, 리턴타입이 없어서 보통 출력문으로 활용*/
	public static void print(List<Person> list, Consumer<Person>c) {
		for(Person p: list) {
			c.accept(p);
		}
	}
	
	/*'Supplier'는 매개변수가 없고, 리턴타입이 있음*/
	public static Person ramdomNumber(Supplier<Person> p) {
		return p.get();
	}
	
	/*'Function'은 매개변수 타입이 A이고 리턴타입이 B
	 * A의 필드를 이용해서 무언가로 가공하고 가공된 결과를 활용할 때 사용
	 * */
	public static void printString(List<Person> list,Function<Person,String>f) {
		for(Person p : list) {
			System.out.println(f.apply(p));
		}
	}
	
	/*'Operator'은 매개변수 타입이 A이고 리턴타입이 A
	 * 
	 * */
	public static void replacePerson(List<Person> list, UnaryOperator<Person> op) {
		for(int i=0;i<list.size();i++) {
			list.set(i, op.apply(list.get(i)));
		}
	}
	
}

@Data
@AllArgsConstructor
class Person{
	private String name;
	private String num;
	private int year;
	
	public String getGender() {
		String gender =num.substring(7,8);
		System.out.println(gender);
		switch(gender) {
		case "1","3":
			return "M";
		case "2","4":
			return "F";
		default:
			throw new RuntimeException("Other");
		}
	}
}
