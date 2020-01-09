package uc.ac.db;

import java.sql.Date;
import java.sql.Timestamp;

public class UploadVO {

	/*
	 * project_num int primary key auto_increment,
	 *  pcontent varchar(100) not null,
	 * id_fk varchar(10) not null,
	 *  pmoney int not null,
	 *   pdate date not null,
	 * pVerify int default 0 , 
	 * regdate Timestamp default now(), 
	 * ppic1 varchar(50) not null, 
	 * phit int default 0
	 */

	private int project_num;
	private String ptitle;
	private String pcontent;
	private int pmoney;
	private String id_fk;
	private Date pdate;
	private int pVerify;
	private Timestamp regdate;
	private String ppic1;
	private int phit;
	 private String name;
	 
	 
	 
	 public String getName() {
	 	return name;
	 }
	 public void setName(String name) {
	 	this.name = name;
	 }
	
	
	public UploadVO(int project_num, String ptitle, String pcontent, int pmoney, String id_fk, Date pdate,
			int pVerify, Timestamp regdate, String ppic1, int phit) {
		super();
		this.project_num = project_num;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.pmoney = pmoney;
		this.id_fk = id_fk;
		this.pdate = pdate;
		this.pVerify = pVerify;
		this.regdate = regdate;
		this.ppic1 = ppic1;
		this.phit = phit;
	}
	public UploadVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProject_num() {
		return project_num;
	}
	public void setProject_num(int project_num) {
		this.project_num = project_num;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public int getPmoney() {
		return pmoney;
	}
	public void setPmoney(int pmoney) {
		this.pmoney = pmoney;
	}
	public String getid_fk() {
		return id_fk;
	}
	public void setid_fk(String id_fk) {
		this.id_fk = id_fk;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getpVerify() {
		return pVerify;
	}
	public void setpVerify(int pVerify) {
		this.pVerify = pVerify;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public String getPpic1() {
		return ppic1;
	}
	public void setPpic1(String ppic1) {
		this.ppic1 = ppic1;
	}
	public int getPhit() {
		return phit;
	}
	public void setPhit(int phit) {
		this.phit = phit;
	}

	

}
