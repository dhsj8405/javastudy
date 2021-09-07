package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		int i,num,sum =0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하시오 : ");
		num = scanner.nextInt();
		if(num % 2 ==0) {
			i = 0;
		}
		else {
			i = 1;
		}
		for(; i < num+1 ; i = i+2) {
			sum = i + sum;
		}
		System.out.println("결과 값 : " + sum);
		
		scanner.close();
	}
}
