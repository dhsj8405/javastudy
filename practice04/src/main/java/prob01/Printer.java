package prob01;

public class Printer {
	private int a;
	private boolean b;
	private double c;
	private String d;
	
//	public void println(int a) {
//		System.out.println(a);
//	}
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//	public void println(double c) {
//		System.out.println(c);
//	}
//	public void println(String d) {
//		System.out.println(d);
//	}
//	
	
	public <T> void println(T t) { //파라미터의 타입들을 리턴타입 앞에적음
//	public <T, R> void println(T t, R r) { 파라미터 두개일때
		System.out.println(t);
	}
	public <T> void println(T... ts) { //파라미터의 타입들을 리턴타입 앞에적음
		for(T t : ts) {
			System.out.println(t);	
		}
	}
	public int sum(Integer... nums) {
		int sum = 0 ;
		for(Integer i : nums) {
			sum+=i;
		}
		return sum;
	}
}