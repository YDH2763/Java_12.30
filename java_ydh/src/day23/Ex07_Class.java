package day23;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class Ex07_Class {
	/* 카페 메뉴를 관리하기 위한 음료 클래스를 만드려고 한다.
	 * 다음 조건을 만족하는 클래스를 선언하세요.
	 * 클래스명:Drink
	 * 필드로 메뉴명과 금액이 필요
	 * 클래스는 캡슐화에 맞춰 구현
	 * - getter/setter를 작성
	 * - 매개변수가 있는 생성자를 작성
	 * - 직렬화/역직렬화가 가능하도록 작성
	 * */
	private static Scanner number=new Scanner(System.in);
	private static List<Drink> list =new ArrayList<Drink>();
	
	public static void main(String[] args) {
		
		Drink drink =new Drink("아메리카노",3000);
		Drink drink1 =new Drink("카페라떼",3500);
		list.add(drink);
		list.add(drink1);
		System.out.println(list);
	}

}

@Getter
@Setter
class Drink implements Serializable{	//직렬화 : +implements Serializable
	//캡슐화 : 변수명에 private 추가
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * @param name
	 * @param money
	 */
	public Drink(String name, int money) {
		this.name = name;
		this.money = money;
	}
	@Override
	public String toString() {
		return "음료 : "+name+"\n"+"가격"+money;
	}
	
	
	
	
}