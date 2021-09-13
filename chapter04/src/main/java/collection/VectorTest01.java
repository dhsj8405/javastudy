package collection;

import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		Vector<String> v = new Vector<>();//<> 안에 타입넣어줌 new Vector<>사이는 생략해도됨
		
//		Vector<int> v = new Vector<>();
//		v.addElement(10); Auto Boxing의 예 10이 객체가됨
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("도우너");
		
		// 순회1
		for(int i = 0 ; i < v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		v.removeElementAt(2);
		
		// 순회2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
	}

}
