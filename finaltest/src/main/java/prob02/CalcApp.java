package prob02;

import java.util.Scanner;

//import com.douzone.paint.I.Drawable;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( "두 정수와 연산자를 입력하시오 >> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );
			
			Arithmetic arithmetic = null;
			
			/* 코드 작성 */
			arithmetic = new Arithmetic() {
				
				@Override
				public int calculate(int a, int b) {
					int calResult =0 ;
					switch(tokens[2]) {
					case "+" : calResult = a + b; break;
					case "-" : calResult = a - b; break;
					case "*" : calResult = a * b; break;
					case "/" : calResult = a / b; break;
					}
					return calResult;
				}
			};
			
			
			int result = arithmetic.calculate(lValue, rValue);

			System.out.println( ">> " + result );
		}
		
		scanner.close();
	}
	
}

