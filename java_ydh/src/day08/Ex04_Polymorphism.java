package day08;
import day08.ex2.Car;
import day08.ex2.KiaCar;
import day08.ex2.benzCar;

public class Ex04_Polymorphism {

	public static void main(String[] args) {
		
		KiaCar kia=new KiaCar();
		benzCar benz = new benzCar();
		
		repair(benz);
		repair(kia);
	}
	
	public static void repair(Car car) {
		car.repair();
	}
}
