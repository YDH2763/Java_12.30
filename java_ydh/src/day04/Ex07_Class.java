package day04;

public class Ex07_Class {

	public static void main(String[] args) {
		Car car1= new Car("현대", "아반떼", 2025);
		System.out.println(car1.Name);
		
		Car car2=new Car("기아", "K5", 2025);
		System.out.println(car2.Name);
		
		car1.print();
		car1.turnOn();
		car1.print();
		car1.changeGear('D');
		for(int i=1;i<=10;i++) {
			car1.speedUp();
		}
		car1.print();
		car1.Color="Green";
		System.out.println(car1.Color);
		//car1.Gear='N';
		
	}

}
/*자동차 클래스
 * -정보 : 연료, 회사, 종류, 색상, 년식, 차이름
 * -기능 : 시동 켜기/끄기, 기어 변경, 액셀, 브레이크, 핸들 변경
 * */
class Car{
	//맴버변수, 필드
	public String Company;
	public String Name;
	public String Type;
	public String Color;
	public int Year;
	public String Oil_Type;
	private boolean Power;	//전원
	private char Gear;	//기어
	private int Speed;	//속력
	private int Deg;	//방향의 각도
	//메소드
	/*시동을 키는 메소드
	 * 매개변수: x
	 * 리턴타입: void
	 * 매소드명 : turnOn*/
	public void turnOn() {
		Power=true;
	}
	public void turnOff(){
		if(Speed==0) {
			Power=false;
		}
	}
	/*엑셀레이터를 밟아서 속력이 1 증가하는 메소드
	 * 매개변수: x
	 * 리턴타입: void
	 * 메소드명:speedUp*/
	public void speedUp() {
		if(Power && (Gear =='D' || Gear=='R')) {
			Speed++;
		}
	}
	public void speedDown() {
		if(Power) {
			Speed--;
		}
	}
	/* 원하는 기어로 변경하는 메소드
	 * 매개변수 : 원하는 기어 = char gear1
	 * 리턴타입 : x=>void
	 * 메소드명: changeGear
	 * */
	public void changeGear(char gear1) {
		if(Power) {
			Gear=gear1;
		}
	}
	public void changeDeg(int deg1) {
		Deg = deg1;
	}
	//자동차 정보를 확인하는 메소드
	public void print() {
		System.out.println("----------------");
		System.out.println("전원 : "+Power);
		System.out.println("속력 : "+Speed);
		System.out.println("기어 : "+Gear);
		System.out.println("----------------");
		
	}
	//기본 생성자
	/*
	 *public Car(){
	 *
	 *}
	 * */
	public Car(String company1){
		Company=company1;
		Gear = 'P';
	}
	//생성자 오버로딩
	public Car(String company1, String name1, int year1){
		Company=company1;
		Name=name1;
		Year=year1;
		Gear='P';
	}
	
}