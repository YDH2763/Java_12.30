package day08.ex2;

public class KiaCar extends Car {
	public String logo ="기아";

	@Override
	public void repair() {
		System.out.println("기아 자동차를 수리합니다.");
	}
}
