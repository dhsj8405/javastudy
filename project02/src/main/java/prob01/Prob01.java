package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		
		System.out.println("50000원 : " + money/50000 + "개");
		System.out.println("10000원 : " + money%50000/10000 + "개");
		System.out.println("5000원 : " + money%50000%10000/5000 + "개");
		System.out.println("1000원 : " + money%50000%10000%5000/1000 + "개");
		System.out.println("500원 : " + money%50000%10000%5000%1000/500 + "개");
		System.out.println("100원 : " + money%50000%10000%5000%1000%500/100 + "개");
		System.out.println("50원 : " + money%50000%10000%5000%1000%500%100/50 + "개");
		System.out.println("10원 : " + money%50000%10000%5000%1000%500%100%50/10 + "개");
		System.out.println("5원 : " + money%50000%10000%5000%1000%500%100%50%10/5 + "개");
		System.out.println("1원 : " + money%50000%10000%5000%1000%500%100%50%10%5/1 + "개");
		scanner.close();
 	}
}