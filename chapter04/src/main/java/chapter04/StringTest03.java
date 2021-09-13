package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		//String s1 = "Hello " + "World " + "Java" + 1.8;
		String s1 = new StringBuffer("Hello ")
		.append("World ")
		.append("Java ")
		.append(1.8)
		.toString();
		
		System.out.println(s1);
		
		String s2 = "";
		for(int i = 0 ; i< 10000; i++) {
//			s2 = s2 + i;
			s2 = new StringBuffer(s2).append(i).toString();
		}
		
		StringBuffer sb2 = new StringBuffer("");
		for(int i = 0 ; i< 10000; i ++ ) {
			sb2.append(i);
		}
		String s3 = sb2.toString();
		System.out.println(s3.length());
		
		// String method들....
		
		String s4  = "aBcAbCabcABC";
		System.out.println(s4.length());
		System.out.println(s4.charAt(2));
		System.out.println(s4.indexOf("abc")); //긴문자여렝서 특정문자열 찾음
		System.out.println(s4.indexOf("abc", 7)); // 시작위치 지정해줌, 못 찾으면 -1이나옴
		System.out.println(s4.substring(3)); // 끝 지정안해주면 끝까지 나옴\
		System.out.println(s4.substring(3,5)); // 3,4번까지 가져옴
		
		String s5 = "    ab    cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("----"+s5.trim()+ "----"); // 공백 제거
		System.out.println("----"+s5.replaceAll(" ","")+"----"); //빈스트링의 공백제거
		
		String[] tokens = s6.split(","); // seperate 가 ,
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" "); //스플릿못하면 원본리턴됨
		for(String s : tokens2) {
			System.out.println(s);
		}
		
	}
}
