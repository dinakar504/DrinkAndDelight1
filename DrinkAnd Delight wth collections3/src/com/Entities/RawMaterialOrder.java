package com.Entities;

import java.util.Date;

public class RawMaterialOrder {
    int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	int orderid;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	int rawid;
	int supplierid;
	int quanvalue;
	String quanunit;
	
	Date dateoford;
	Date dateofdel;
	int totalprice;
	String deliveryStus;
	
	public int getRawid() {
		return rawid;
	}
	public void setRawid(int rawid) {
		this.rawid = rawid;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public int getQuanvalue() {
		return quanvalue;
	}
	public void setQuanvalue(int quanvalue) {
		this.quanvalue = quanvalue;
	}
	public String getQuanunit() {
		return quanunit;
	}
	public void setQuanunit(String quanunit) {
		this.quanunit = quanunit;
	}
	public Date getDateoford() {
		return dateoford;
	}
	public void setDateoford(Date dateoford) {
		this.dateoford = dateoford;
	}
	public Date getDateofdel() {
		return dateofdel;
	}
	public void setDateofdel(Date dateofdel) {
		this.dateofdel = dateofdel;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getDeliveryStus() {
		return deliveryStus;
	}
	public void setDeliveryStus(String deliveryStus) {
		this.deliveryStus = deliveryStus;
	}
	public int getWarehouseid() {
		return warehouseid;
	}
	public void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}
	int warehouseid;
	@Override
	public String toString() {
		return userid+"\t\t\t"+orderid+"\t" +rawid+"\t"+supplierid+"\t"+quanvalue+"\t\t\t"+dateoford+"\t\t\t"+dateofdel+"\t\t\t"+totalprice+"\t"+deliveryStus+"\t"+warehouseid;
	}
	
}
