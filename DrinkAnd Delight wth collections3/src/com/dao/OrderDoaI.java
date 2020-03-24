package com.dao;

import java.util.Map;
import java.util.Set;

import com.Entities.RawMaterialOrder;
import com.Entities.RawMaterialSpecs;
import com.Entities.Supplier;
import com.Entities.Warehouse;

public interface OrderDoaI {

	RawMaterialOrder dispalyOrders(int uid, int orderid) throws OrderIDNotFound;

	void updateOrder(int uid, int orderid, int value) throws OrderIDNotFound;

	Set<RawMaterialOrder> display(int userid);

	boolean validate(int uid, String uname);

	void CreateOrder(RawMaterialOrder r);

	Map<Integer, Supplier> supplier();

	Map<Integer, RawMaterialSpecs> rawMaterialSpecs();

	Map<Integer, Warehouse> watehouseDetails();

	RawMaterialSpecs rawMaterialForPrice(int rid);

}
