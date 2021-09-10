package prob5;

public class MyStack {
	static String tmp[]; 
	static String tmp2[];
	static int index = 0 ;
	
	public MyStack(int i) {
		tmp = new String[i];
	}

	public boolean isEmpty() {

		return false;
	}

	public void push(String string) {
		tmp[index] = string;
		index++;
		if (index == tmp.length) {
			tmp2 = tmp;//.clone();
			tmp = new String[index + 2];
			for (int i = 0; i < tmp2.length; i++) {
				tmp[i] = tmp2[i];
			}
			tmp2 = null;
		}
	}


//	public String pop() {
//		return ;
//	}
}