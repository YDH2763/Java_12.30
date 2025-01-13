package day10;

import java.util.HashMap;

public class Ex11_HashMap {

	public static void main(String[] args) {
		/*Map 인터페이스
		 * -Key, Value 값을 관리
		 * -Key : 중복 x
		 * -Value : 중복 o*/
		
		HashMap<String,String> map=new HashMap<String,String>();
		//put(k,v) :k와 v의 값을 각각 Key,Value 에 추가하여 저장		
		//k가 중복된 경우 v로 덮어쓰기 함
		//
		map.put("abc123", "qwer123");
		map.put("abc1234", "qwer1234");
		map.put("abc1234", "qwer123");	
		
		System.out.println(map);
		
		/*get(k)
		  -key값 중에서 k와 일치하는 value를 변환
		  -없으면 null로 변환	
		 	*/
		System.out.println(map.get("qwe1234"));
		System.out.println(map.get("abc123"));
		/*isEmpty(
		 * -map이 비어었는지를 반환
		 * containsKey(k)
		 * -Key값 중에서 k와 일치하는 값이 있는지를 반환
		 * containsValue(v)
		 * -Value값 중에서 v와 일치하는 값이 있는지를 반환
		 * */
		System.out.println(map.isEmpty());
		System.out.println(map.containsKey("abc"));
		System.out.println(map.containsKey("abc123"));
		System.out.println(map.containsValue("qwer123"));
		System.out.println(map.containsValue("abc"));
		
		/*remove(k)
		 * -Key값 중에 k와 일치하는 값이 있으면 삭제후 value를 반환
		 * remove(k,v)
		 * -Key값 중에 k와 일치하고, valu값 중에 v와 일치하는 값이 있으면
		 * 	삭제 후 삭제 여부를 반환
		 * */
		System.out.println("삭제 전");
		System.out.println(map);
		System.out.println(map.remove("abc123"));
		System.out.println("삭제 후");
		System.out.println(map);
		System.out.println(map.remove("abc1234","qwer123"));
		System.out.println("삭제 후");
		System.out.println(map);
		
	
	}


}
