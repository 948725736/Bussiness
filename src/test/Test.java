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
		System.out.println("请选择功能：1.注册2.登录3.退出");
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
	 System.out.println("请输入用户id");
	 String id=sc.next();
	 System.out.println("请输入用户密码");
	 String password=sc.next();
	 User user=users.get(id);
	 if(user==null){
		 System.out.println("此id不存在");
		 return null;
	 }
	 if(!password.equals(user.getPassword())){
		 System.out.println("密码错误，登录失败");
		 return null;
	 }
	 System.out.println("登录成功");
	 return user;
 }
 
}
