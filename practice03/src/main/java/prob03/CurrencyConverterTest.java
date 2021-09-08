package prob03;

public class CurrencyConverterTest {
	private static double rate;
	public static double toDollar(double won) {
		//한국 원화를 달러로 변환
		return won/rate;
	}
	public static double toKRW(double dollar) {
		// 달러를 한국 원화로 변환
		return dollar*rate;
	}
	public static void setRate(double r) {
		//환율 설정(KRW/$1)
		rate = r;
	}
	public static void main(String[] args) {
		//  환율을 세팅 합니다.
		CurrencyConverterTest.setRate(1197.0);
		
		double dollar = CurrencyConverterTest.toDollar( 1000000. );
		System.out.println( "백만원은 " + dollar + "달러 입니다" );
		
		double krw = CurrencyConverterTest.toKRW( 100. );
		System.out.println( "백달러는 " + krw + "원 입니다" );
	}

}
