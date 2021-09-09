package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("some codes1......");
		
		try {
			
			System.out.println("some codes2......");
			int result = ( 1 + 2 + 3 )/ b;
			System.out.println("some codes3......");
			System.out.println("some codes4......");
		}catch(ArithmeticException e) {
			/*예외 처리*/
			// 1. 사과
			System.out.println("미안합니다.");
			// 2. 로깅
			System.out.println("error:"+e);
			// 3. 정상종료
			return;
		} finally {
			System.out.println("자원 정리");
		}		
	}
}
