package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
		System.out.print("금액: ");
		int inputMoney , i, result;

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
		inputMoney = scanner.nextInt();
		System.out.println("");
		result = inputMoney;
		for(i = 0 ; i < MONEYS.length ; i ++) {
			for(int j = 0  ; j< i ; j ++) {
				result = inputMoney % MONEYS[j];
			}
			result = result / MONEYS[i];
			System.out.println(MONEYS[i] + "원 : " + result + "개");
		}
		
//		System.out.println("50000원 : " + inputMoney/50000 + "개");
//		System.out.println("10000원 : " + inputMoney%50000/10000 + "개");
//		System.out.println("5000원 : " + inputMoney%50000%10000/5000 + "개");
//		System.out.println("1000원 : " + inputMoney%50000%10000%5000/1000 + "개");
//		System.out.println("500원 : " + inputMoney%50000%10000%5000%1000/500 + "개");
//		System.out.println("100원 : " + inputMoney%50000%10000%5000%1000%500/100 + "개");
//		System.out.println("50원 : " + inputMoney%50000%10000%5000%1000%500%100/50 + "개");
//		System.out.println("10원 : " + inputMoney%50000%10000%5000%1000%500%100%50/10 + "개");
//		System.out.println("5원 : " + inputMoney%50000%10000%5000%1000%500%100%50%10/5 + "개");
//		System.out.println("1원 : " + inputMoney%50000%10000%5000%1000%500%100%50%10%5/1 + "개");
		scanner.close();
 	}
}