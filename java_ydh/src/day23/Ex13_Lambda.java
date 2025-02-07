package day23;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Lambda {

	public static void main(String[] args) {
		List<Point3> list = new ArrayList<Point3>();
		list.add(new Point3(0,0));
		list.add(new Point3(1,1));
		list.add(new Point3(-1,-1));
		
		//x좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트하세요.
		xPlus(list);
		//y좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트하세요.
		yPlus(list);
		//람다식으로 전체 좌표 출력
		xyLambda(list,new Predicate<Point3>() {
			@Override
			public boolean test(Point3 t) {
				return true;
			}
		});
		xyLambda(list,t->true);
		//람다식을 이용하여 x좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트하세요.
		xyLambda(list,p->p.getX()>0);
		//람다식을 이용하여 y좌표가 0이상인 좌표들만 출력되도록 메소드를 만들어서 테스트하세요.
		xyLambda(list,p->p.getY()>0);
		//람다식 => 메소드를 간결하게 표현해서 객체를 생성할 때 사용()->{}
		//람다식은 함수형 인터페이스의 객체를 만들 때 사용
	}

	private static void xPlus(List<Point3> list) {
		for(Point3 temp:list) {
			if(temp.getX()>=0) {
				System.out.println(temp);
			}
		}
	}

	private static void yPlus(List<Point3> list) {
		for(Point3 temp:list) {
			if(temp.getY()>=0) {
				System.out.println(temp);
			}
		}
		
	}

	private static void xyLambda(List<Point3> list,Predicate<Point3> p) {
		for(Point3 temp:list) {
			if(p.test(temp)) {
				System.out.println(temp);
			}
		}
	}

	

}
@AllArgsConstructor
@Data
class Point3{
	private int x,y;
}