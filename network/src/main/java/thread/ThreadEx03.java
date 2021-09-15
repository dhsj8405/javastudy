package thread;

public class ThreadEx03 {
	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnableImpl()); //스레드를 상속받지못할때 만들어져있는 클래스의 메소드를 건드리지않을때 사용
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
