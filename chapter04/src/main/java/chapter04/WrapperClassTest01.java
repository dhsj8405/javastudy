package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		Integer i = new Integer(10);
		Character c = new Character('c');
		Boolean b = new Boolean(true);
		
		
		//리터럴풀이 작동해서 new한것과 같은 객체
		//Auto Boxing : 자동으로 클래스만들어서 객체로 매핑해주는 것
		Integer j1 = 10;
		Integer j2 = 10;
		
		System.out.println(j1 == j2 ); //new와 다르게 string과 똑같이 리터럴 풀이 작용해서 같다고나옴
		System.out.println(j1.equals(j2));
		
		//메소드로 값을 빼내야함
		//int m = j1.intValue() + 10 ; //객체 + 10 자동으로 언박싱됨
		// Auto UnBoxing 기능이 있기때문에 밑에 처럼 작성하면됨
		int m = j1 + 10 ; 
		
		
		
		
	}

}
