package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		double [] d1 = ArrayUtils.intToDouble(new int[]{10, 20, 30, 40});
		System.out.println(Arrays.toString(d1));
		
		int[] a2 = ArrayUtils.doubleToInt(new double[]{10.1, 20.1, 30.1, 40.1});
		System.out.println(Arrays.toString(a2));
		
		int[] a3 = ArrayUtils.concat(new int[]{1,2,3,4},new int[]{5,6,7,8});
		System.out.println(Arrays.toString(a3));
	}

}
