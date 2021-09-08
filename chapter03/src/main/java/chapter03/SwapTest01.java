package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int tmp = 0;
		System.out.println(a + ":" + b);
		
		/* swap하기*/
		tmp = a;
		a = b;
		b = tmp;
		
		System.out.println(a + ":" + b);
	}

}
