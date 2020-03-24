package com.service;

import java.util.Map;
import java.util.Set;

import com.Entities.RawMaterialOrder;
import com.Entities.RawMaterialSpecs;
import com.Entities.Supplier;
import com.Entities.Warehouse;
import com.dao.OrderIDNotFound;

public interface OrderServiceI {

	void createOrder(RawMaterialOrder e);

	RawMaterialSpecs rawMaterialForPrice(int rid);

	Map<Integer, Warehouse> watehouseDetails();

	Map<Integer, Supplier> supplier();

	Map<Integer, RawMaterialSpecs> rawMaterialSpecs();

	void updateOrder(int uid, int orderid, int value) throws OrderIDNotFound;

	Set<RawMaterialOrder> display(int userid);

	boolean validate(int uid, String uname);

	RawMaterialOrder displayOrders(int userid, int oid) throws OrderIDNotFound;

}
