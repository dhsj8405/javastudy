package chapter03;

public class ArrayUtils {
	static double[] result;
	static int[] result1;
	static double[]intToDouble(int[] source) {
		result  = new double[source.length];
		for(int i=0 ; i < source.length ; i++) {
		result[i] = (double)source[i];
		}
		return result;
	}
//	
	static int[] doubleToInt( double[] source ) {
		result1  = new int[source.length];
		for(int i=0 ; i < source.length ; i++) {
		result1[i] = (int)source[i];
		}
		return result1;
	}
	static int[] concat( int[] s1, int[] s2 ) {
		result1 = new int[s1.length + s2.length];
		for(int i=0 ; i < result1.length ; i++) {
			if(s1.length>i) {
				result1[i] = s1[i];
			}else {
				result1[i] = s2[i-s1.length];
			}
			
		}
		return result1;
	}

}
