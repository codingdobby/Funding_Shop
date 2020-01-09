package projectDB;

public class ProjectVO {
	
 private String ptitle;
 private String name;
 private int pmoney;
 private String pdate;
 private String pcontent;
 private String ppic1;
 private int project_num;
 private int phit;
 private int totMoney;

 private int prodCount;

 

public int getProdCount() {
	return prodCount;
}
public void setProdCount(int prodCount) {
	this.prodCount = prodCount;
}
public int getTotMoney() {
	return totMoney;
}
public void setTotMoney(int totMoney) {
	this.totMoney = totMoney;
}
public int getPhit() {
	return phit;
}
public void setPhit(int phit) {
	this.phit = phit;
}
public int getProject_num() {
	return project_num;
}
public void setProject_num(int project_num) {
	this.project_num = project_num;
}
public String getPpic1() {
	return ppic1;
}
public void setPpic1(String ppic1) {
	this.ppic1 = ppic1;
}
public String getPtitle() {
	return ptitle;
}
public void setPtitle(String ptitle) {
	this.ptitle = ptitle;
}

public int getPmoney() {
	return pmoney;
}
public void setPmoney(int pmoney) {
	this.pmoney = pmoney;
}
public String getPdate() {
	return pdate;
}
public void setPdate(String pdate) {
	this.pdate = pdate;
}


public String getPcontent() {
	return pcontent;
}
public void setPcontent(String pcontent) {
	this.pcontent = pcontent;
}
public ProjectVO() {
	super();
	// TODO Auto-generated constructor stub
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public ProjectVO(String ptitle, String name, int pmoney, String pdate, String pcontent, String ppic1, int project_num,
		int phit) {
	super();
	this.ptitle = ptitle;
	this.name = name;
	this.pmoney = pmoney;
	this.pdate = pdate;
	this.pcontent = pcontent;
	this.ppic1 = ppic1;
	this.project_num = project_num;
	this.phit = phit;
}








}
