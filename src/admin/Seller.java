package admin;

public  class Seller extends User {
private String id;//�̼�id
private String name;//�̼ҵ�������
private String password;//�̼�����
private String sellerName;//�̼�����
private long  phone;//�̼ҵ绰
private String license;//ִ��
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
public String getsellerName() {
	return sellerName;
}
public void setsellerName(String sellerName) {
	this.sellerName = sellerName;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getLicense() {
	return license;
}
public void setLicense(String license) {
	this.license = license;
}
@Override
public String toString() {
	return "Seller [id=" + id + ", name=" + name + ", password=" + password + ", sellerName=" + sellerName + ", phone="
			+ phone + ", license=" + license + "]";
}
public Seller(){}
public Seller(String id, String name, String password, String sellerName, long phone, String license) {
	this.id = id;
	this.name = name;
	this.password = password;
	this.sellerName = sellerName;
	this.phone = phone;
	this.license = license;
}
@Override
public void Menu() {
	// TODO Auto-generated method stub
	test.Menu.SellerMenu(this);
}
}
