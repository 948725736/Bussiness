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
		System.out.println("��ѡ���ܣ�1.����̼�2.��ͨ�û���ֵ3.�˳�");
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
		System.out.println("��ѡ���ܣ�1.�����Ʒ2.ɾ����Ʒ3.��������4.������һ��");
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
		System.out.println("��ѡ����:1.������Ʒ2.�����Ʒ3.�г�����4.�鿴���ﳵ0.������һ��");
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
