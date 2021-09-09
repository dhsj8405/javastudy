package chapter03;

public class Student extends Person {
	private int grade;
	private String major;
	
	public Student() {
		// 자식의 모든 생성자에서 
		// 부모의 특정 생성자를 명시(explicity)하지 않으면
		// 암시적(implicity)으로 부모의 기본 생성자가 
		// 자식 생성자 코드 앞에 호출된다.
		//super(); //부모클래스 생성자를 먼저 부르기때문에 super();을 밑에 프린트문의 밑에 적으면 안됨
		System.out.println("Student() called");
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
