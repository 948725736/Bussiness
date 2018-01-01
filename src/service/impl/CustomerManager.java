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
	System.out.println("�������û�id");
	String id=sc.next();
	if(Test.users.containsKey(id)){
		System.out.println("���û��Ѵ���");
		return;
	}
	System.out.println("�������û���");
	String name=sc.next();
	System.out.println("�������û�����");
	String password=sc.next();
	System.out.println("�������û��绰");
	long phone =sc.nextLong();
	Customer customer=new Customer(id,name,password,phone,0);
	Test.users.put(id, customer);
	System.out.println("��ӳɹ�");
}
public void lookWareByWareName(Customer customer){
	System.out.println("��������Ҫ��������Ʒ����");
	String wareNeme=sc.next();
	Map<String,Ware> wares=Tools.getWaresByWareName(wareNeme);
	if(wares.size()==0){
		System.out.println("������������Ʒ");
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
	System.out.println("��������Ҫ�������ƷId");
	String wareId=sc.next();
	Ware ware=wares.get(wareId);
	if(ware.getStock()==0){
		System.out.println("�����Ʒ���¼�");
		return;
	}
	while(true){
		System.out.println("��ѡ���ܣ�1.ֱ�ӹ�����Ʒ2.���빺�ﳵ0.�˳�");
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
	System.out.println("�����빺������");
	int county=sc.nextInt();
	while(true){
		if(county<=0){
			System.out.println("������ļ�����������������");
			county=sc.nextInt();
			continue;
		}if(county>ware.getStock()){
			System.out.println("��治�㣬���޸ļ���");
			county=sc.nextInt();
			continue;
		}
		break;
	}
	System.out.println("�����뷢����ַ");
	String address = sc.next();
	System.out.println("��������ϵ��");
	String contact = sc.next();
	System.out.println("��������ϵ�绰");
	int phone = sc.nextInt();
	System.out.println("�����뱸ע");
	String remark = sc.next();
	
	if(customer.getBalance() < ware.getPrice()*county){
		System.out.println("���㣬���ֵ����");
		return;
	}
	Order order = new Order(ware.getWareId(), ware.getWareName(), ware.getPrice(), county, 
			address, contact, phone, remark,customer.getId(), ware.getSellerId());
	
	Test.orders.add(order);
	System.out.println("����ɹ�");
}
public void balance(Customer customer){
	System.out.println(customer.getBalance());
}
public void OrderList(Customer customer){
	ArrayList<Order> orders=Tools.getWithoutOrderByUserId(customer.getId());
	orders.addAll(Tools.getOrderByUserId(customer.getId()));
	System.out.println("��Ķ������£�");
	for(int i=0;i<orders.size();i++){
		System.out.println("-----------------");
		System.out.println(orders.get(i));
	}
}
public void shoppingCar(Customer customer){
	ArrayList<Car> cars=Tools.getCarsById(customer.getId());
	while(true){
		if(cars.isEmpty()){
			System.out.println("���ﳵû���κ���Ʒ");
			return;
		}
		System.out.println("���ﳵ��Ϣ���£�");
		for(int i=0;i<cars.size();i++){
			System.out.println("----------------------");
			Ware ware =Tools.getWareByWareId( cars.get(i).getWareId());
			System.out.println((i+1) + ":");
			System.out.println(ware);
			System.out.println("����:	 " + cars.get(i).getCounty());
			System.out.println("---------------------------");
		}
	System.out.println("��ѡ���ܣ�1.����2.�Ƴ���Ʒ3.��չ��ﳵ0.������һ��");
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
	System.out.println("�����뷢����ַ��");
	String address=sc.next();
	System.out.println("��������ϵ��");
	String contact=sc.next();
	System.out.println("��������ϵ�绰");
	int phone=sc.nextInt();
	System.out.println("�����뱸ע");
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
		System.out.println("���㣬���ֵ���ټ�������");
		return;
	}
	Test.orders.addAll(orders);
		removeAll(cars,customer);	
		System.out.println("����ɹ�");
}
private void remove(ArrayList<Car> cars,Customer customer){
	System.out.println("��������Ҫɾ������Ʒ���");
	int index=sc.nextInt();
	Test.cars.remove(cars.get(index-1));
	cars.remove(index-1);
	System.out.println("�Ƴ��ɹ�");
}
private void removeAll(ArrayList<Car> cars,Customer customer){
	for(Car car: cars){
		Test.cars.remove(car);
		cars.remove(car);
	}
}
}

