package prob04;

public class Person {
	private static int numberOfPerson=0; // 전체 인구수
	private int age;
	private String name;
	
	public Person() {
		this.age = 12;
		this.name = "";
		numberOfPerson ++;
	}
	public Person(int age, String name) {
		numberOfPerson ++;
		this.age = age;
		this.name = name;
	}
	public Person(String name) {
		this();
		this.name = name;
	}
	public static int getPopulation() {
		return numberOfPerson;
	}
	public void selfIntroduce() {
		System.out.println("내 이름은 " + this.name + "이며, 나이는 " + this.age + "살입니다.");		
	}
	
	/* 코드 작성 */
}
