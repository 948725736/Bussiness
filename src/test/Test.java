package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import admin.Car;
import admin.Order;
import admin.User;
import admin.Ware;
import service.impl.CustomerManager;

public class Test {
 public  static Map<String,User> users=new HashMap<>();
 public  static Map<String,Ware> wares=new HashMap<>();
 public static List<Order> orders=new ArrayList<>();
 public static List<Car> cars=new ArrayList<>();
 public static 	Scanner sc = new Scanner(System.in);
 public static void main(String[] args) {
	while(true){
		System.out.println("��ѡ���ܣ�1.ע��2.��¼3.�˳�");
		int mark=sc.nextInt();
		if(mark==1){
			CustomerManager.addCustomer();
		}else if(mark==2){
			User log=Login();
			if(log==null){
				continue;
			}
			log.Menu();
		}else{
			System.exit(0);
		}
	}
}
 private static User Login(){
	 System.out.println("�������û�id");
	 String id=sc.next();
	 System.out.println("�������û�����");
	 String password=sc.next();
	 User user=users.get(id);
	 if(user==null){
		 System.out.println("��id������");
		 return null;
	 }
	 if(!password.equals(user.getPassword())){
		 System.out.println("������󣬵�¼ʧ��");
		 return null;
	 }
	 System.out.println("��¼�ɹ�");
	 return user;
 }
 
}
