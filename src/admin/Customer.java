package admin;

public class Customer extends User{
private String id;
private String name;
private String password;
private long number;
private long balance;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", number=" + number + ", balance="
			+ balance + "]";
}
public Customer(){}
public Customer(String id, String name, String password, long number, long balance) {
	this.id = id;
	this.name = name;
	this.password = password;
	this.number = number;
	this.balance = balance;
}
@Override
public void Menu() {
	// TODO Auto-generated method stub
	test.Menu.CustomerMenu(this);
}
}
