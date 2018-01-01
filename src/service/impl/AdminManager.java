package service.impl;
import java.util.Scanner;

import admin.Customer;
import admin.Seller;
import admin.User;
import test.Test;
public class AdminManager {
public Scanner sc=new Scanner(System.in);
public void addSeller(){
	System.out.println("请输入商家id");
	String id=sc.next();
	if(Test.users.containsKey(id)){
		System.out.println("该用户已存在");
		return;
	}
	System.out.println("请输入商家店铺名称");
	String name=sc.next();
	System.out.println("请输入商家密码");
	String password=sc.next();
	System.out.println("请输入商家名字");
	String sellerName=sc.next();
	System.out.println("请输入商家联系电话");
	long phone=sc.nextLong();
	System.out.println("请输入商家执照");
	String license=sc.next();
	Seller sellser=new Seller(id,name,password,sellerName,phone,license);
	Test.users.put(id, sellser);
	System.out.println("添加成功");
}
 public void recharge(){
	 System.out.println("请输入充值账号");
	 String id=sc.next();
	 User user=Test.users.get(id);
	 if(user==null){
		 System.out.println("该用户不存在");
		 return;
	 }else{
		 if(user.getClass()==Customer.class){
		 Customer c=(Customer)user;
		 System.out.println("请输入充值的金额");
		 int money=sc.nextInt();
		  c.setBalance(c.getBalance()+money);
		 System.out.println("充值成功");
	 }else{
		 System.out.println("输入的不是普通用户");
		 return;
	 }
} 
 }

}
