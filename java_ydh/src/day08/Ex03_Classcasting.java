package day08;

public class Ex03_Classcasting {

	public static void main(String[] args) {
		/* 다양한 자동차를 관리하는 프로그램을 만드는 상황
		 * */
		Car[] list = new Car[10];
		//업캐스팅. 자동 클래스 변환
		list[0]=new BenzCar();
		list[1]=new KiaCar();
		int c=2;
		for(int i=0;i<c;i++) {
			Car tmp=list[i];
			if(tmp instanceof KiaCar) {
				KiaCar kiatmp=(KiaCar)tmp;
				System.out.println(kiatmp.logo);
			}
			else if(tmp instanceof BenzCar) {
				BenzCar benztmp=(KiaCar)tmp;
				System.out.println(((BenzCar)tmp).logo);
			}
			
			
		}
		
	}

}
