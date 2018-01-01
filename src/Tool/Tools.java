package Tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import admin.Car;
import admin.Order;
import admin.Ware;
import test.Test;

public class Tools {
public static Map<String , Ware> getWaresByWareName(String wareName){
	Map<String,Ware>wares=new HashMap();
	Set<String>keys=Test.wares.keySet();
	Iterator<String> iter=keys.iterator();
	while(iter.hasNext()){
		String s=iter.next();
		Ware ware=Test.wares.get(s);
		if(wareName.equals(ware.getWareName())){
			wares.put(s,ware);
		}
	}
	return wares;
}
public static ArrayList<Order> getWithoutOrderByUserId(String UserId){
	ArrayList<Order>list=new ArrayList<Order>();
	Iterator<Order> iter=list.iterator();
	while(iter.hasNext()){
		Order order=iter.next();
		if(order.getOrderId() == null&&(UserId.equals(order.getSellerId())
				||UserId.equals(order.getBuyerId()))){
			list.add(order);
		}
	}
	return list;
}
public static ArrayList<Order> getOrderByUserId(String UserId){
	ArrayList<Order>list=new ArrayList<Order>();
	Iterator<Order> iter=list.iterator();
	while(iter.hasNext()){
		Order order=iter.next();
		if(order.getOrderId()!=null&&(UserId.equals(order.getSellerId())
				||UserId.equals(order.getBuyerId()))){
			list.add(order);
		}
	}
	return list;
}
public static Order getOrderByOrderId(String orderId){
	Iterator<Order>iter =Test.orders.iterator();
	while(iter.hasNext()){
		Order order=iter.next();
		if(orderId.equals(order.getOrderId())){
			return order;
		}
	}
	return null;
}
public static ArrayList <Car> getCarsById(String userId){
	ArrayList<Car> cars=new ArrayList<>();
	Iterator<Car>iter=Test.cars.iterator();
	while(iter.hasNext()){
		Car car=iter.next();
		if(car.getId().equals(userId)){
			cars.add(car);
		}
	}
	return cars;
}
public static Ware getWareByWareId(String wareId){
	Set<String> keys=Test.wares.keySet();
	Iterator<String>iter=keys.iterator();
	while(iter.hasNext()){
		String key=iter.next();
		Ware ware =Test.wares.get(key);
		if(wareId.equals(ware.getWareId())){
			return ware;
		}
	}
	return null;
}
}
