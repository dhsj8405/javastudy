package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(String accountNo){
		this.accountNo = accountNo;
	}
	public void save(int a) {
		balance = balance + a;
	}
	public void deposit(int b) {
		balance = balance - b;
	}
	
}
