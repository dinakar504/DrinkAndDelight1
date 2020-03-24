package com.ui;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.Entities.RawMaterialOrder;
import com.Entities.RawMaterialSpecs;
import com.Entities.Supplier;
import com.Entities.Warehouse;
import com.dao.OrderIDNotFound;
import com.service.OrderService;
import com.service.OrderServiceI;

public class Ui {
	static OrderServiceI s=new OrderService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter uid ");//uid===1
		int uid=sc.nextInt();
		System.out.println("enter upass");//upass==din
		String pass=sc.next();
		if(s.validate(uid, pass))
		{
			while(true)
			{
				System.out.println("1.Display single order details\n2.update an order\n3.dispaly all orders");
				int option=sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("enter orderid ");
					try
					{
						RawMaterialOrder orders=s.displayOrders(uid,sc.nextInt());
		                System.out.println("oid\trawid\tsupid\tquanval\t\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\ttotalprice\tdelsta\twareid");

						System.out.println(orders.getOrderid()+"\t"+orders.getRawid()+"\t"+orders.getSupplierid()+"\t"+orders.getQuanvalue()+"\t\t\t"+orders.getDateoford()+"\t\t\t"+orders.getDateofdel()+"\t\t\t"+orders.getTotalprice()+"\t"+orders.getDeliveryStus()+"\t"+orders.getWarehouseid());

					}
					catch (OrderIDNotFound e) {
						// TODO: handle exception
						System.err.println(e.getMessage());
					}
					break;
				case 2:
					Set set1=s.display(uid);
					Iterator i1=set1.iterator();
					System.out.println("uid\t\t\toid\trawid\tsupid\tquanval\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\t\ttotalprice\tdelsta\twareid");

					while(i1.hasNext())
					{
						Entry e1=(Entry) i1.next();
						
						System.out.println(e1.getValue());
					}
					System.out.println("enter orderid you want change");
					int oid=sc.nextInt();
					System.out.println("enter quan value to change");
					int value=sc.nextInt();
					try
					{
						s.updateOrder(uid,oid,value);
						RawMaterialOrder orders1=s.displayOrders(uid,oid);
		                System.out.println("uid\toid\trawid\tsupid\tquanval\t\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\ttotalprice\tdelsta\twareid");
						System.out.println(orders1.getUserid()+"\t"+orders1.getOrderid()+"\t"+orders1.getRawid()+"\t"+orders1.getSupplierid()+"\t"+orders1.getQuanvalue()+"\t\t\t"+orders1.getDateoford()+"\t\t\t"+orders1.getDateofdel()+"\t\t\t"+orders1.getTotalprice()+"\t"+orders1.getDeliveryStus()+"\t"+orders1.getWarehouseid());	
					}
					catch (OrderIDNotFound e) {
						// TODO: handle exception
						System.err.println(e.getMessage());
					}
					
					break;
				case 3:
					Set set=s.display(uid);
					Iterator i=set.iterator();
					System.out.println("uid\t\t\toid\trawid\tsupid\tquanval\t\t\tdate of ord\t\t\t\t\tdateof del\t\t\t\ttotalprice\tdelsta\twareid");

					while(i.hasNext())
					{
						Entry e=(Entry) i.next();
						
						System.out.println(e.getValue());
					}
						
					break;
				case 4:
                     RawMaterialOrder e=new RawMaterialOrder();
                     e.setUserid(uid);
                     System.out.println("enter quantity");
                     int quan=sc.nextInt();
                     e.setQuanvalue(quan);
                     
                     System.out.println("enter warehouse id for producing");
                     Map<Integer, Warehouse> ware=s.watehouseDetails();
                      Set set11= ware.entrySet();
                     Iterator i11=set11.iterator();
                     System.out.println("wareid\twarename\twareadd");
                     while(i11.hasNext())
                     {
                    	 Entry<Integer,Warehouse> e11=(Entry) i11.next();
                    	 System.out.println(e11.getValue().getWarehid()+"\t"+e11.getValue().getWarehname()+"\t"+e11.getValue().getWareadd());
                     }
                     System.out.println("enter id");
                     e.setWarehouseid(sc.nextInt());
                     
                     System.out.println("enter supplier id");
                     Map< Integer, Supplier> sup=s.supplier();
                     Set set12= sup.entrySet();
                     Iterator i12=set12.iterator();
                     System.out.println("supid\tsupname\tsupadd");
                     while(i12.hasNext())
                     {
                    	 Entry<Integer,Supplier> e12=(Entry) i12.next();
                    	 System.out.println(e12.getValue().getSid()+"\t"+e12.getValue().getSname()+"\t"+e12.getValue().getSadd());
                     }
                     e.setSupplierid(sc.nextInt());
                     System.out.println("enter rawMAterial");
                     Map <Integer,RawMaterialSpecs> rawspec=s.rawMaterialSpecs();
                     Set set13= rawspec.entrySet();
                     Iterator i13=set13.iterator();
                     System.out.println("rawid\trawname\trawmaterialpriceperunit");
                     while(i13.hasNext())
                     {
                    	 Entry<Integer,RawMaterialSpecs> e13=(Entry) i13.next();
                    	 System.out.println(e13.getValue().getRawid()+"\t"+e13.getValue().getRawname()+"\t"+e13.getValue().getRawpp());
                     }
                     int raw1=sc.nextInt();
                     e.setRawid(raw1);
                     e.setTotalprice(s.rawMaterialForPrice(raw1).getRawpp()*quan);
                     e.setDateoford(new Date());
                     Calendar cal1= Calendar.getInstance();
             		cal1.setTime(e.getDateoford());
             		cal1.add(Calendar.DATE, 4);
             		Date modifiedDate1 = cal1.getTime();
             		 e.setDateofdel(modifiedDate1);
                     s.createOrder(e);
				default:
					break;
				}
				
			}

		}
		else
			System.err.println("invalid user");
		

	}

}
