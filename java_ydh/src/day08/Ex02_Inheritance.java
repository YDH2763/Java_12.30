package day08;
import lombok.Data;
public class Ex02_Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KiaCar kia =new KiaCar();
		//kia.powe=true;=>에러 발생 : 다른 클래스에서 private을 사용할 수 없다.
		kia.turnOn();
		System.out.println(kia.isPower());
		kia.speed=10;//protected는 자기+패키지+자식
	}

}

@Data
class Car{
	private boolean power;
	protected int speed;
	
	public void turnOn() {this.power=true;}
	public void turnOff() {this.power=false;}
	
	public void speedUp() {
		speed++;
	}
	public void speedDown() {
		speed--;
	}
	
	public void repair() {
		System.out.println("자동차를 수리합니다.");
	}
}

