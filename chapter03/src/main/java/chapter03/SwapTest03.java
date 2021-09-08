package chapter03;

public class SwapTest03 {

	public static void main(String[] args) {
		Value a = new Value(10); // 레퍼런스값 1000이 a에 들어감 레퍼런스 1000이 heap영역의 val = 10 을 가리킴
		Value b = new Value(20);

		System.out.println(a.val + ":" + b.val);
		
		/* swap하기*/

		swap(a,b);
		System.out.println(a.val + ":" + b.val);
	}
	
	public static void swap(Value p, Value q) {
		int tmp = p.val;
		p.val = q.val;
		q.val = tmp;
	}
}
