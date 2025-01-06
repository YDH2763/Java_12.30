package day05;

public class Ex04_static {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KiaCar k1=new KiaCar("레이");
		KiaCar k2=new KiaCar("니로");
		KiaCar k3=new KiaCar("K5");
		
		//k1.setCompany("KIA");
		KiaCar.setCompany("KIA");
		
		k1.print();
		k2.print();
		k3.print();
	}

}

class KiaCar{

	private static String company;
	private String carName;
	
	public String getCompany() {
		return company;
	}
	public static void setCompany(String company) {
		KiaCar.company = company;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void print() {
		System.out.println(carName);
	}
	
	public KiaCar(String carName) {
		company = "기아";
		this.carName = carName;
	}
	
}