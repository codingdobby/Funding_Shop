package uc.ac.db;

public class CartVO {
	/*card_id int primary key auto_increment ,
	id_fk varchar(30),
	prodNum_fk int,
	project_num_fk int,
	amount int,*/
	
	private String id_fk;
	private int prodNum_fk; 
	private int project_num_fk;
	private int amount;
	
	private int price;
	private String ptitle;
	private String prodName;
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getId_fk() {
		return id_fk;
	}
	public void setId_fk(String id_fk) {
		this.id_fk = id_fk;
	}
	public int getProdNum_fk() {
		return prodNum_fk;
	}
	public void setProdNum_fk(int prodNum_fk) {
		this.prodNum_fk = prodNum_fk;
	}
	public int getProject_num_fk() {
		return project_num_fk;
	}
	public void setProject_num_fk(int project_num_fk) {
		this.project_num_fk = project_num_fk;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

	
	
	
	
}
