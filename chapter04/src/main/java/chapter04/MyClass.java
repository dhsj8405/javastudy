package chapter04;

public class MyClass {
	private static MyClass instance = null;
	private MyClass(){
		
	}
	//Singleton + Factory method
	public static MyClass getInstance() {
		if(instance == null) {
			instance = new MyClass();
		}
		return instance;
	}
}
