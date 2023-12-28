package com.ilp.entity;
import java.util.ArrayList;
public abstract class Products  {
	private String productCode;
	private String productName;
	private ArrayList <Service> productServicelist=new ArrayList<Service>();
	
	public Products(String productCode, String productName, ArrayList<Service> productServicelist) {
		this.productCode = productCode;
		this.productName = productName;
		this.productServicelist = productServicelist;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Service> getServicetList() {
		return productServicelist;
	}
	public void setServicetList(ArrayList<Service> servicetList) {
		this.productServicelist = servicetList;
	}
	@Override
	public String toString() {
		return "Products [productCode=" + productCode + ", productName=" + productName + ", servicetList="
				+ productServicelist + "]";
	}
	
	

}
