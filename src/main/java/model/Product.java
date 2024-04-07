package model;

import java.io.Serializable;

public class Product implements Serializable{
	private int pId;
	private String pname;
	private String pdesc;
	private String pimage;
	private int psize;
	private int pquantity;
	private double pprice;
	private int category_id;
	
	public Product() {
	}

	public Product(int pId, String pname, String pdesc, String pimage, int psize, int pquantity, double pprice,
			int category_id) {
		this.pId = pId;
		this.pname = pname;
		this.pdesc = pdesc;
		this.pimage = pimage;
		this.psize = psize;
		this.pquantity = pquantity;
		this.pprice = pprice;
		this.category_id = category_id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public int getPquantity() {
		return pquantity;
	}

	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pname=" + pname +  
				  ", pquantity=" + pquantity + ", pprice=" + pprice + ", category_id=" + category_id + "]" + "\n";
	}
	
	
}
