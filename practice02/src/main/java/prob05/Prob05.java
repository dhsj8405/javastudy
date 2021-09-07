package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int i=0,inputNum;
		int minRange = 1 ,maxRange = 100;
		while( true ) {
			
			/* 게임 작성 */
			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");

			while(true) {
				i++;
				System.out.println(minRange + "-" + maxRange);
				System.out.print(i + ">>");
				inputNum = scanner.nextInt();
				if(inputNum > correctNumber) {
					System.out.println("더 낮게");
					maxRange = inputNum;	
				}else if(inputNum < correctNumber) {
					System.out.println("더 높게");
					minRange = inputNum ;
				}else {
					System.out.println("맞았습니다.");
					break;
				}
			}
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
			maxRange = 100;
			minRange = 1;
			i = 0;
		}
		
		scanner.close();
	}

}