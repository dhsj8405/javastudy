package prob5;

public class MyStack {
	static String myStack[];
	static String popReturn;
	static String tmp[]; 
	static String checkEmpty = " ";
	static int index = 0 ;
	
	public MyStack(int i) {
		myStack = new String[i];
	}

public boolean isEmpty() {
	return (checkEmpty == null)? true : false;
	}
	public void push(String string) {
		myStack[index++] = string;
		if (index == myStack.length) {
			tmp = myStack;
			myStack = new String[index + 2];
			for (int i = 0; i < tmp.length; i++) {
				myStack[i] = tmp[i];
			}
			tmp = null;
		}
	}	
	public String pop() throws MyStackException {
		index--;
		if (index == -1) {
			throw new MyStackException();
		}

		popReturn = myStack[index];
		tmp = new String [index];
		for(int i = 0 ; i < index ; i ++) {
			tmp[i] = myStack[i];
		}
		myStack = new String[index];
		for(int i = 0 ; i < index ; i ++) {
			myStack[i] = tmp[i] ; 
		}
		if(myStack.length == 0){
			checkEmpty = null;
		}
		return popReturn ;
	}

}