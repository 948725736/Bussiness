package service.impl;
import java.util.Scanner;

import admin.Customer;
import admin.Seller;
import admin.User;
import test.Test;
public class AdminManager {
public Scanner sc=new Scanner(System.in);
public void addSeller(){
	System.out.println("�������̼�id");
	String id=sc.next();
	if(Test.users.containsKey(id)){
		System.out.println("���û��Ѵ���");
		return;
	}
	System.out.println("�������̼ҵ�������");
	String name=sc.next();
	System.out.println("�������̼�����");
	String password=sc.next();
	System.out.println("�������̼�����");
	String sellerName=sc.next();
	System.out.println("�������̼���ϵ�绰");
	long phone=sc.nextLong();
	System.out.println("�������̼�ִ��");
	String license=sc.next();
	Seller sellser=new Seller(id,name,password,sellerName,phone,license);
	Test.users.put(id, sellser);
	System.out.println("��ӳɹ�");
}
 public void recharge(){
	 System.out.println("�������ֵ�˺�");
	 String id=sc.next();
	 User user=Test.users.get(id);
	 if(user==null){
		 System.out.println("���û�������");
		 return;
	 }else{
		 if(user.getClass()==Customer.class){
		 Customer c=(Customer)user;
		 System.out.println("�������ֵ�Ľ��");
		 int money=sc.nextInt();
		  c.setBalance(c.getBalance()+money);
		 System.out.println("��ֵ�ɹ�");
	 }else{
		 System.out.println("����Ĳ�����ͨ�û�");
		 return;
	 }
} 
 }

}
