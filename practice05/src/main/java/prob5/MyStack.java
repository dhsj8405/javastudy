package prob5;

public class MyStack {
	static String tmp;
	static String tmp1[]; 
	static String tmp2[];
	static String pop_tmp1[];
	static String checkEmpty = " ";
	static int index = 0 ;
	static int a =1 ;
	
	public MyStack(int i) {
		tmp1 = new String[i];
	}

	public boolean isEmpty() {
		
		return (checkEmpty == null)? true : false;
	}

	public void push(String string) {
		tmp1[index++] = string;
		if (index == tmp1.length) {
			tmp2 = tmp1;
			tmp1 = new String[index + 2];
			for (int i = 0; i < tmp2.length; i++) {
				tmp1[i] = tmp2[i];
			}
			tmp2 = null;
		}
	}
	public String pop() {
		index--;
		tmp = tmp1[index];
		pop_tmp1 = new String [index];
			for(int i = 0 ; i < index ; i ++) {
				pop_tmp1[i] = tmp1[i];
			}
		if(index == 0){
			checkEmpty = null;
		}
		return tmp ;
	}
}