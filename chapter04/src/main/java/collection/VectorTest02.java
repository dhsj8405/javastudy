package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		//순회1
		for(int i = 0 ; i< list.size(); i ++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//삭제
		list.remove(2);
		
		//순회2 
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
//		: 한번 쓴 이터레이터는 또 못씀 새로운 이터레이터 객체 다시 생성해줘야함
//		while(it.hasNext()) {
//			String s = it.next();
//			System.out.println(s);
//		}
		
		//순회3
		for(String s : list) {
			System.out.println(s);
		}
		
	}

}
