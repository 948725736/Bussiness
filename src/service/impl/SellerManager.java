package service.impl;

import java.util.ArrayList;
import java.util.Scanner;

import Tool.Tools;
import admin.Customer;
import admin.Order;
import admin.Seller;
import admin.Ware;
import test.Test;

public class SellerManager {
public static Scanner sc=new Scanner(System.in);
public void addWare(Seller seller){
	System.out.println("请输入你要添加的商品编号");
	String wareId=sc.next();
	if(Test.wares.containsKey(wareId)){
		System.out.println("该商品已存在");
		return; 
	}
	System.out.println("请输入商品名称");
	String wareName=sc.next();
	System.out.println("请输入商品价格");
	int price=sc.nextInt();
	System.out.println("请输入商品描述");
	String desc=sc.next();
	System.out.println("请输入商品库存");
	int stock=sc.nextInt();
	
	Ware ware=new Ware(wareId,wareName,price,stock,desc,seller.getId());
	Test.wares.put(wareId,  ware);
	System.out.println("添加成功");
}
public void deleteWare(){
	System.out.println("请输入你要删除的商品编号");
	String wareId=sc.next();
	if(!Test.wares.containsKey(wareId)){
		System.out.println("该商品不存在");
		return;
	}
	Test.wares.remove(wareId);
	System.out.println("删除成功");
}
public void orderManager(Seller seller){
	while(true){
		System.out.println("请选择功能：1.查看未发货订单2.查看已发货订单3.返回上一级");
		int mark=sc.nextInt();
		if(mark==1){
			ArrayList<Order> orders=Tools.getWithoutOrderByUserId(seller.getId());
			if(orders.size()==0){
				System.out.println("当前没有未发货订单");
				continue;
			}
			System.out.println("已发货订单信息如下：");
			for(int i=0;i<orders.size();i++){
				System.out.println("-----------------");
				System.out.println((i+1)+":"+orders.get(i));
			}
			System.out.println("1.发货2.返回上一级");
			int x=sc.nextInt();
			if(x==1){
				System.out.println("请选择订单");
				int index=sc.nextInt();
				String orderId;
				while(true){
					System.out.println("请选择订单号");
					orderId=sc.next();
					if(Tools.getOrderByOrderId(orderId)!=null){
						System.out.println("该订单号已存在，请重新输入");
						continue;
					}
					break;
				}
				orders.get(index-1).setOrderId(orderId);
				System.out.println("已成功发货");
			}else if(x==0){
				break;
			}
			}else if(mark==2){
			ArrayList<Order> orders=Tools.getOrderByUserId(seller.getId());
			if(orders.size()==0){
				System.out.println("当前没有任何订单");
				continue;
			}
			System.out.println("所有已发货订单如下：");
			for(int i=0;i<orders.size();i++){
				System.out.println("-----------------");
				System.out.println((i+1)+":"+orders.get(i));
			}
		}else if(mark==0){
			break;
		}
		}
	}
}

