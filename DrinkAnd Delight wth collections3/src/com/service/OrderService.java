package com.service;

import java.util.Map;
import java.util.Set;

import com.Entities.RawMaterialOrder;
import com.Entities.RawMaterialSpecs;
import com.Entities.Supplier;
import com.Entities.Warehouse;
import com.dao.OrderDoa;
import com.dao.OrderDoaI;
import com.dao.OrderIDNotFound;

public class OrderService implements OrderServiceI {
	
	OrderDoaI d=new OrderDoa();
	 @Override
	public RawMaterialOrder displayOrders(int userid,int oid) throws OrderIDNotFound
 {
	
	 return d.dispalyOrders(userid,oid);
	 
 } @Override
	public void updateOrder(int uid,int orderid,int value ) throws OrderIDNotFound{
		
			d.updateOrder(uid,orderid, value);
		
		
	}
	
 @Override
	public Set<RawMaterialOrder> display(int userid)
	{
		return d.display(userid);
	}
 @Override
	
	public boolean validate(int uid,String uname)
	{
		return d.validate(uid, uname);
	}
 @Override
	public Map<Integer,RawMaterialSpecs> rawMaterialSpecs()
	  {
		  return d.rawMaterialSpecs();
	  }
 @Override
	  public Map<Integer,Supplier> supplier()
	  {
		  return d.supplier();
	  }
 @Override
	  public Map<Integer, Warehouse> watehouseDetails()
	  {
		  return d.watehouseDetails();
	  }
 @Override
	  public RawMaterialSpecs rawMaterialForPrice(int rid)
	  {
		  return d.rawMaterialForPrice(rid);
	  }
 @Override
	public void createOrder(RawMaterialOrder e) {
		// TODO Auto-generated method stub
		d.CreateOrder(e);
	}
	
}
