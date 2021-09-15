package prob05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prob5.MyStackException;

public class LoginMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<User> joinUsers = new ArrayList<User>();
		joinUsers.add(new User("둘리", "1234"));
		joinUsers.add(new User("마이콜", "5678"));
		joinUsers.add(new User("또치", "4321"));
		joinUsers.add(new User("도우너", "8765"));

		System.out.print("아이디를 입력하시오 : ");
		String id = scanner.nextLine();

		System.out.print("비밀번호를 입력하시오 : ");
		String password = scanner.nextLine();

		try {
			login(joinUsers, new User(id, password));
			System.out.println("로그인 성공");
		} catch (UserNotFoundException ex) {
			System.out.println("사용자를 찾을 수 없습니다.");
			return;
		} catch (PasswordDismatchException ex) {
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		} finally {
			scanner.close();
		}
	}

	public static void login(List<User> users, User user) {
		/* 코드 작성 */
		int idKey = 0;
		int pwKey = 0;
		for (User id : users) {
			if (user.getId() == id.getId()) {
				idKey = 1;
				for (User pw : users) {
					if (user.getPassword() == pw.getPassword()) {
						pwKey = 1;
					}
				}
			}	
		}
		if(idKey == 0) {
			throw new UserNotFoundException();
		}else if(pwKey == 0) {
			throw new PasswordDismatchException();	
		}
		
		
//		user.getId() == users.get
//		
//		user.getPassword()
//		ser == users.get(1).getId()
//		users.get(1).getPassword()

//		 == user.getId()
//		user.getPassword()
	}
}
