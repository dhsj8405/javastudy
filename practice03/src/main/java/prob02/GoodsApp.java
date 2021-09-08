package prob02;

import java.util.Scanner;


public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		int i;
		String tmp[] = new String[COUNT_GOODS] ;
		Scanner scanner = new Scanner(System.in);		
		Goods[] goods = new Goods[COUNT_GOODS];
		for( i= 0; i<COUNT_GOODS ; i ++) {
			int index = 0;
			String s = scanner.nextLine();
			String[] tokens = s.split(" ");
			for(String str :  tokens) {
				tmp[index] = str;
				index ++;
				
			}
			goods[i] = new Goods(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]));
		}
		
		// 상품 출력

		// 자원정리
		for(i = 0 ; i< 3 ; i++) {
			System.out.println(goods[i].getName()+"(가격: "+goods[i].getPrice()+"원)이 "+goods[i].getCountStock()+"개 입고 되었습니다.");	
		}
		
		scanner.close();
	}
}
