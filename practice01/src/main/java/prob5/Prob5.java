package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int i;
		int num_10,num_1;		
		for(i=1 ; i<100 ; i++) {
			num_10 = i / 10;
			num_1 = i % 10;
			
			// %연산자로 3의배수를 표현할때 0을 제외하는 방법
			//십의자리가 0이고 1의자리가 3의 배수가 0이 아닐때 출력x
			if(num_10 == 0 && num_1 % 3 != 0)
				continue;
			//일의자리는 0이고 십의자리가 3의 배수가 아닐때 출력x
			if(num_1 == 0 && num_10 % 3 != 0)
				continue;
			//둘중에 하나라도 3의 배수일 때 숫자 출력
			if (num_10 % 3 == 0 || num_1 % 3 == 0) {
				System.out.print(i + " ");
				//십의자리 3인지 아닌지 판단 후 짝 출력
				if(num_10 != 0 && num_10 % 3 == 0){
					System.out.print("짝");
				}
				//일의자리 3인지 아닌지 판단 후 짝 출력
				if(num_1 != 0 && num_1 % 3 == 0) {
					System.out.print("짝");
				}
				System.out.println();
			}
		}		
	}
}
