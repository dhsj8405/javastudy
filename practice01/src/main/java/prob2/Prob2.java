package prob2;

import java.util.Scanner;

public class Prob2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int i,j ;
		
		for( j=0; j<5 ; j ++)
		{	
			for(i = 0; i < 10 ;i ++) {
				System.out.print(j + i + 1 + " ");
			}
			System.out.println();
		}
	}

}
