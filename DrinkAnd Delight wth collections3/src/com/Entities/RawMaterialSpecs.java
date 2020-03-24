package com.Entities;

public class RawMaterialSpecs {
int rawid;
String rawname;
int rawpp;
public int getRawid() {
	return rawid;
}
public void setRawid(int rawid) {
	this.rawid = rawid;
}
public String getRawname() {
	return rawname;
}
public void setRawname(String rawname) {
	this.rawname = rawname;
}
public int getRawpp() {
	return rawpp;
}
@Override
public String toString() {
	return "RawMaterialSpecs [rawid=" + rawid + ", rawname=" + rawname + ", rawpp=" + rawpp + "]";
}
public void setRawpp(int rawpp) {
	this.rawpp = rawpp;
}
}
