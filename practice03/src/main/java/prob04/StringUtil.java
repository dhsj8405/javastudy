package prob04;

import java.util.ArrayList;

public class StringUtil {
	public static String concatenate(String[] str) {
		ArrayList<String> s = new ArrayList<>();
		for(int i = 0 ; i<3 ; i++) {
			s.add(str[i]);	
		}
		return s.toString();
	}
}
