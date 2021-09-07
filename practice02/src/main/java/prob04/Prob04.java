package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
//		System.out.println( str.charAt(str.length()-1) );
		int j = 0;
		
		char[] tmp =  new char[str.length()];
		for(int i = str.length() - 1; i >= 0  ; i--) {
			tmp[j] = str.charAt(i) ;
			j++;
		}
		return tmp;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}