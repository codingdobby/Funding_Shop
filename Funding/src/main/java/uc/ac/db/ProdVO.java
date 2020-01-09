package uc.ac.db;

public class ProdVO {
	private int prodNum;
	private String prodName;
	private int prodPrice;
	private int prodCount;
	private int project_num_fk;

	public ProdVO(int prodNum, String prodName, int prodPrice, int prodCount, int project_num_fk) {
		super();
		this.prodNum = prodNum;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodCount = prodCount;
		this.project_num_fk = project_num_fk;
	}

	public int getProject_num_fk() {
		return project_num_fk;
	}

	public void setProject_num_fk(int project_num_fk) {
		this.project_num_fk = project_num_fk;
	}

	public ProdVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

}
