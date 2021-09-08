package chapter03;

public class SwatTest02 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.println(a + ":" + b);
		
		/* swap하기*/

		swap(a,b);
		System.out.println(a + ":" + b);
	}
	public static void swap(int p, int q) {
		int tmp = p;
		p = q;
		q = tmp;
	}
}
