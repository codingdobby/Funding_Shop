package uc.ac.db.project;

public class CatVO {
	private String category_name;
	private int category_id;

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public CatVO(String category_name, int category_id) {
		super();
		this.category_name = category_name;
		this.category_id = category_id;
	}

	public CatVO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
