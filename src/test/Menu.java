package test;

import java.util.Scanner;

import admin.Admin;
import admin.Customer;
import admin.Seller;
import service.impl.AdminManager;
import service.impl.CustomerManager;
import service.impl.SellerManager;

public class Menu {
	public static Scanner sc=new Scanner(System.in);
	public static AdminManager a=new AdminManager();
	public static SellerManager s=new SellerManager();
	public static CustomerManager c=new CustomerManager(); 
public static void AdminMenu(Admin admin){
	while(true){
		System.out.println("请选择功能：1.添加商家2.普通用户充值3.退出");
		int mark=sc.nextInt();
		if(mark==1){
			a.addSeller();
		}else if(mark==2){
			a.recharge();
		}else{
			System.exit(0);
		}
	}
} 
public static void SellerMenu(Seller seller){
	while(true){
		System.out.println("请选择功能：1.添加商品2.删除商品3.订单管理4.返回上一级");
		int mark= sc.nextInt();
		if(mark==1){
			s.addWare(seller);
		}else if(mark==2){
			s.deleteWare();
		}else if(mark==3){
			s.orderManager(seller);
		}else if(mark==4){
			break;
		}
	}
}
public static void CustomerMenu(Customer customer){
	while(true){
		System.out.println("请选择功能:1.搜索商品2.随机商品3.列出订单4.查看购物车0.返回上一级");
		int mark=sc.nextInt();
		if(mark==1){
			c.lookWareByWareName(customer);;
		}else if(mark==2){
			//c.suiji();
		}else if(mark==3){
			c.OrderList(customer);
		}else if(mark==4){
			c.shoppingCar(customer);
		}else if(mark==0){
			break;
		}
	}
}
}
