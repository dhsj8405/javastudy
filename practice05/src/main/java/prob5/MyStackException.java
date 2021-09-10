package prob5;

public class MyStackException extends Exception {

	@Override
	public String toString() {
		return "MyStackException: stack is empty";
	}

}
