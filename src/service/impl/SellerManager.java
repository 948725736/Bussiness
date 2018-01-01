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
	System.out.println("��������Ҫ��ӵ���Ʒ���");
	String wareId=sc.next();
	if(Test.wares.containsKey(wareId)){
		System.out.println("����Ʒ�Ѵ���");
		return; 
	}
	System.out.println("��������Ʒ����");
	String wareName=sc.next();
	System.out.println("��������Ʒ�۸�");
	int price=sc.nextInt();
	System.out.println("��������Ʒ����");
	String desc=sc.next();
	System.out.println("��������Ʒ���");
	int stock=sc.nextInt();
	
	Ware ware=new Ware(wareId,wareName,price,stock,desc,seller.getId());
	Test.wares.put(wareId,  ware);
	System.out.println("��ӳɹ�");
}
public void deleteWare(){
	System.out.println("��������Ҫɾ������Ʒ���");
	String wareId=sc.next();
	if(!Test.wares.containsKey(wareId)){
		System.out.println("����Ʒ������");
		return;
	}
	Test.wares.remove(wareId);
	System.out.println("ɾ���ɹ�");
}
public void orderManager(Seller seller){
	while(true){
		System.out.println("��ѡ���ܣ�1.�鿴δ��������2.�鿴�ѷ�������3.������һ��");
		int mark=sc.nextInt();
		if(mark==1){
			ArrayList<Order> orders=Tools.getWithoutOrderByUserId(seller.getId());
			if(orders.size()==0){
				System.out.println("��ǰû��δ��������");
				continue;
			}
			System.out.println("�ѷ���������Ϣ���£�");
			for(int i=0;i<orders.size();i++){
				System.out.println("-----------------");
				System.out.println((i+1)+":"+orders.get(i));
			}
			System.out.println("1.����2.������һ��");
			int x=sc.nextInt();
			if(x==1){
				System.out.println("��ѡ�񶩵�");
				int index=sc.nextInt();
				String orderId;
				while(true){
					System.out.println("��ѡ�񶩵���");
					orderId=sc.next();
					if(Tools.getOrderByOrderId(orderId)!=null){
						System.out.println("�ö������Ѵ��ڣ�����������");
						continue;
					}
					break;
				}
				orders.get(index-1).setOrderId(orderId);
				System.out.println("�ѳɹ�����");
			}else if(x==0){
				break;
			}
			}else if(mark==2){
			ArrayList<Order> orders=Tools.getOrderByUserId(seller.getId());
			if(orders.size()==0){
				System.out.println("��ǰû���κζ���");
				continue;
			}
			System.out.println("�����ѷ����������£�");
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

