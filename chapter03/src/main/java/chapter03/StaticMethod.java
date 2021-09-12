package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
		//같은 클래스에서는 클래스(static)변수 접근에서는 클래스 이름 생략
	}
	void f2() {
		System.out.println(m);
	}
	void f3() {
		f2();
	}
	static void s1() {
		//오류 : static 메소드에서는 인스턴스 변수 접근 불가)
		//System.out.println(n);
	}
	static void s2() {
		System.out.println(StaticMethod.m);
		//같은 클래스에서는 클래스(static)변수 접근에서는 클래스 이름 생략
		System.out.println(m);
	}
	static void s3() {
		//오류 : static method 에서는 인스턴스 메소드에 접근할 수 없다.
		//f1();
	}
	static void s4() {
		s1();
	}
}
