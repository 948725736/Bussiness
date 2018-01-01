package service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import Tool.Tools;
import admin.Car;
import admin.Customer;
import admin.Order;
import admin.Ware;
import test.Test;

public class CustomerManager {
	public static Scanner sc=new Scanner(System.in);
public static void addCustomer(){
	System.out.println("请输入用户id");
	String id=sc.next();
	if(Test.users.containsKey(id)){
		System.out.println("该用户已存在");
		return;
	}
	System.out.println("请输入用户名");
	String name=sc.next();
	System.out.println("请输入用户密码");
	String password=sc.next();
	System.out.println("请输入用户电话");
	long phone =sc.nextLong();
	Customer customer=new Customer(id,name,password,phone,0);
	Test.users.put(id, customer);
	System.out.println("添加成功");
}
public void lookWareByWareName(Customer customer){
	System.out.println("请输入你要搜索的商品名字");
	String wareNeme=sc.next();
	Map<String,Ware> wares=Tools.getWaresByWareName(wareNeme);
	if(wares.size()==0){
		System.out.println("搜索不到该商品");
		return;
	}
	SelectWares(wares,customer);
}
private void SelectWares(Map<String ,Ware>  wares,Customer customer){
	Set<String> keys=wares.keySet();
	Iterator<String>iter=keys.iterator();
	while(iter.hasNext()){
		String key=iter.next();
		Ware ware=wares.get(key);
	System.out.println(ware);
	}
	System.out.println("请输入你要购买的商品Id");
	String wareId=sc.next();
	Ware ware=wares.get(wareId);
	if(ware.getStock()==0){
		System.out.println("这件物品已下架");
		return;
	}
	while(true){
		System.out.println("请选择功能：1.直接购买商品2.加入购物车0.退出");
		int mark=sc.nextInt();
		if(mark==1){
			buyWare(ware,customer);
		}else if(mark==2){
			shoppingCar(customer);
		}else if(mark==0){
			break;
		}
	}
}
public void buyWare(Ware ware,Customer customer){
	System.out.println("请输入购买数量");
	int county=sc.nextInt();
	while(true){
		if(county<=0){
			System.out.println("你输入的件数有误，请重新输入");
			county=sc.nextInt();
			continue;
		}if(county>ware.getStock()){
			System.out.println("库存不足，请修改件数");
			county=sc.nextInt();
			continue;
		}
		break;
	}
	System.out.println("请输入发货地址");
	String address = sc.next();
	System.out.println("请输入联系人");
	String contact = sc.next();
	System.out.println("请输入联系电话");
	int phone = sc.nextInt();
	System.out.println("请输入备注");
	String remark = sc.next();
	
	if(customer.getBalance() < ware.getPrice()*county){
		System.out.println("余额不足，请充值后购买");
		return;
	}
	Order order = new Order(ware.getWareId(), ware.getWareName(), ware.getPrice(), county, 
			address, contact, phone, remark,customer.getId(), ware.getSellerId());
	
	Test.orders.add(order);
	System.out.println("购买成功");
}
public void balance(Customer customer){
	System.out.println(customer.getBalance());
}
public void OrderList(Customer customer){
	ArrayList<Order> orders=Tools.getWithoutOrderByUserId(customer.getId());
	orders.addAll(Tools.getOrderByUserId(customer.getId()));
	System.out.println("你的订单如下：");
	for(int i=0;i<orders.size();i++){
		System.out.println("-----------------");
		System.out.println(orders.get(i));
	}
}
public void shoppingCar(Customer customer){
	ArrayList<Car> cars=Tools.getCarsById(customer.getId());
	while(true){
		if(cars.isEmpty()){
			System.out.println("购物车没有任何商品");
			return;
		}
		System.out.println("购物车信息如下：");
		for(int i=0;i<cars.size();i++){
			System.out.println("----------------------");
			Ware ware =Tools.getWareByWareId( cars.get(i).getWareId());
			System.out.println((i+1) + ":");
			System.out.println(ware);
			System.out.println("数量:	 " + cars.get(i).getCounty());
			System.out.println("---------------------------");
		}
	System.out.println("请选择功能：1.结算2.移除商品3.清空购物车0.返回上一级");
	int mark=sc.nextInt();
	if(mark==1){
		settlement(cars,customer);
	}else if(mark==2){
		remove(cars,customer);
	}else if(mark==3){
		removeAll(cars,customer);
	}else if(mark==0){
		break;
		}
	}
	}
private void settlement(ArrayList <Car> cars,Customer customer){
	System.out.println("请输入发货地址：");
	String address=sc.next();
	System.out.println("请输入联系人");
	String contact=sc.next();
	System.out.println("请输入联系电话");
	int phone=sc.nextInt();
	System.out.println("请输入备注");
	String remark=sc.next();
	ArrayList<Order> orders=new ArrayList();
	int sumPrice=0;
	for(Car car:cars){
	Ware ware=Tools.getWareByWareId(car.getWareId());
	Order order = new Order(ware.getWareId(), ware.getWareName(), ware.getPrice(), car.getCounty(),
			address, contact, phone, remark, customer.getId(), ware.getSellerId());
	orders.add(order);
	sumPrice +=ware.getPrice()*car.getCounty();
	}
	if(sumPrice>customer.getBalance()){
		System.out.println("余额不足，请充值后再继续购买");
		return;
	}
	Test.orders.addAll(orders);
		removeAll(cars,customer);	
		System.out.println("购买成功");
}
private void remove(ArrayList<Car> cars,Customer customer){
	System.out.println("请输入你要删除的商品序号");
	int index=sc.nextInt();
	Test.cars.remove(cars.get(index-1));
	cars.remove(index-1);
	System.out.println("移除成功");
}
private void removeAll(ArrayList<Car> cars,Customer customer){
	for(Car car: cars){
		Test.cars.remove(car);
		cars.remove(car);
	}
}
}

