package day08.ex2;

public class benzCar extends Car{
	public String logo = "벤츠";
	
	@Override
	public void repair() {
		System.out.println("벤츠를 수리합니다.");
	}
}
