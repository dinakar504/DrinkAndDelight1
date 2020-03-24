package com.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.Entities.RawMaterialOrder;
import com.Entities.RawMaterialSpecs;
import com.Entities.Supplier;
import com.Entities.User;
import com.Entities.Warehouse;

public class OrderDoa implements OrderDoaI{
	Map<Integer,RawMaterialOrder> a=new HashMap<Integer,RawMaterialOrder>();
	Map<Integer,RawMaterialSpecs> b=new HashMap<Integer,RawMaterialSpecs>();
	Map<Integer,User> c=new HashMap<Integer, User>();
	Map<Integer,Supplier> d=new HashMap<Integer, Supplier>();
	Map<Integer,Warehouse> e=new HashMap<Integer, Warehouse>();
	
			static int ord1=4;
   public OrderDoa() {
	// TODO Auto-generated constructor stub
	   Warehouse w=new Warehouse();
	   w.setWareadd("hyd");
	   w.setWarehid(1);
	   w.setWarehname("nagarjuna");
	   e.put(1, w);
	   Warehouse w1=new Warehouse();
	   w1.setWareadd("Secunderabad");
	   w1.setWarehid(2);
	   w1.setWarehname("Yaswanth");
	   e.put(2, w1);
	   
	   
	   
	   Supplier sup=new Supplier();
	   sup.setSadd("andra");
	   sup.setSid(1);
	   sup.setSname("chiru");
	   d.put(1,sup);
	   Supplier sup1=new Supplier();
	   sup1.setSadd("Telangana");
	   sup1.setSid(2);
	   sup1.setSname("Ram");
	   d.put(2,sup1);
	   
	   
	  User u=new User();
	  u.setUserid(1);
	  u.setPass("din");
	  c.put(u.getUserid(), u);
	  
	  User u1=new User();
	  u1.setUserid(2);
	  u1.setPass("din1");
	  c.put(u1.getUserid(), u1);
	   RawMaterialSpecs s=new RawMaterialSpecs();
	   s.setRawid(1);
	   
	   s.setRawname("Fanta");
	   s.setRawpp(10);
	   b.put(1,s);
	   RawMaterialSpecs s1=new RawMaterialSpecs();
	   s1.setRawid(2);
	   
	   s1.setRawname("banta");
	   s1.setRawpp(20);
	   b.put(2,s1);
	   RawMaterialOrder r1=new RawMaterialOrder();
	   r1.setOrderid(1);
	   r1.setRawid(1);
	   r1.setDateoford(new Date());
	  r1.setUserid(1);
	   Calendar cal = Calendar.getInstance();
		cal.setTime(r1.getDateoford());
		cal.add(Calendar.DATE, 4);
		Date modifiedDate = cal.getTime();
		 r1.setDateofdel(modifiedDate);
	   r1.setDeliveryStus("True");
	  // r1.setQuanunit();
	   r1.setQuanvalue(5);
	   r1.setTotalprice(50);
	   r1.setSupplierid(1);
	   r1.setWarehouseid(1);
	   a.put(1, r1);
	   RawMaterialOrder r=new RawMaterialOrder();
	   r.setUserid(2);
	   r.setOrderid(2);
	   r.setRawid(2);
	   r.setDateoford(new Date());
	  
	
	   Calendar cal1= Calendar.getInstance();
		cal1.setTime(r1.getDateoford());
		cal1.add(Calendar.DATE, 4);
		Date modifiedDate1 = cal1.getTime();
		 r.setDateofdel(modifiedDate1);
	   r.setDeliveryStus("True");
	  // r1.setQuanunit();
	   r.setQuanvalue(5);
	   r.setTotalprice(50);
	   r.setSupplierid(1);
	   r.setWarehouseid(1);
	   a.put(2, r);
	   RawMaterialOrder r2=new RawMaterialOrder();
	   r2.setUserid(2);
	   r2.setOrderid(3);
	   r2.setRawid(2);
	   r2.setDateoford(new Date());
	  
	   Calendar cal2= Calendar.getInstance();
		cal2.setTime(r1.getDateoford());
		cal2.add(Calendar.DATE, 4);
		Date modifiedDate2 = cal2.getTime();
		 r2.setDateofdel(modifiedDate2);
	   r2.setDeliveryStus("True");
	  // r1.setQuanunit();
	   r2.setQuanvalue(5);
	   r2.setTotalprice(50);
	   r2.setSupplierid(1);
	   r2.setWarehouseid(1);
	   a.put(3, r2);
}
   @Override
   public RawMaterialOrder dispalyOrders(int uid,int orderid) throws OrderIDNotFound 
   {
	   RawMaterialOrder new4=a.get(orderid);
	   if(a.containsKey(orderid)&&new4.getUserid()==uid)
	   {
		   return  (RawMaterialOrder) a.get(orderid);
	   }
	   else
		   throw new OrderIDNotFound("No order present");
	   
   }
   @Override
  public void updateOrder(int uid,int orderid,int value ) throws OrderIDNotFound{
	 
	  if(a.containsKey(orderid))
		  {
		  RawMaterialOrder new1=a.get(orderid);
		  System.out.println("hello");
			 if(new1.getUserid()==uid)
			 {
				 new1.setQuanvalue(value);
				 
				 RawMaterialSpecs aa=(RawMaterialSpecs) b.get(new1.getRawid());
//				 System.out.println((RawMaterialSpecs)b.get(new1.getRawid()));
//				 System.out.println(new1.getRawid());
				 new1.setTotalprice(aa.getRawpp()*value);
				 System.out.println(new1.getTotalprice());
				 a.put(orderid, new1);
			}
		  }
	
	 else 
		 throw new OrderIDNotFound("NO order id as such found");
	 }
   @Override
  public Set<RawMaterialOrder> display(int userid)
  {
	  Map new2=new HashMap();
	  Set set=a.entrySet();
	  Iterator i=set.iterator();
	  while(i.hasNext())
	  {
	  	Entry e=(Entry) i.next();
	  	RawMaterialOrder a1=(RawMaterialOrder)e.getValue();
	  	if(a1.getUserid()==userid)
	  	{
	  		
	  		new2.put(a1.getOrderid(),e);
	  	}
	  }
    	return new2.entrySet(); 
  }
   @Override
  public boolean validate(int uid,String uname)
  {
	// System.out.println("hello");
	 if(c.containsKey(uid))
	 {
		 User u1= c.get(uid);
		 if(u1.getPass().equals(uname)) {
			 return true;
		 }
	 }
	return false;
  }
   @Override
  public void CreateOrder(RawMaterialOrder r)
  {
	  r.setDeliveryStus("true");
	  r.setOrderid(ord1);
	 
	  a.put(ord1,r);
	  ord1++;
	 
  }
   @Override
  public Map<Integer,RawMaterialSpecs> rawMaterialSpecs()
  {
	  return b;
  }
   @Override
  public Map<Integer,Supplier> supplier()
  {
	  return d;
  }
   @Override
  public Map<Integer, Warehouse> watehouseDetails()
  {
	  return e;
  }
   @Override
  public RawMaterialSpecs rawMaterialForPrice(int rid)
  {
	  return  b.get(rid);
  }
}
