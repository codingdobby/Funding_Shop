package uc.ac.db;

import java.sql.Timestamp;

public class NoticeVO {
	
	private int notice_num;
	private String nTitle; 
	private String nContent; 
	private String nWriter;
	private Timestamp nRegdate;
	private int nhits;
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnWriter() {
		return nWriter;
	}
	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}
	public Timestamp getnRegdate() {
		return nRegdate;
	}
	public void setnRegdate(Timestamp nRegdate) {
		this.nRegdate = nRegdate;
	}
	public int getNhits() {
		return nhits;
	}
	public void setNhits(int nhits) {
		this.nhits = nhits;
	}
	public NoticeVO(int notice_num,String nTitle, String nContent, String nWriter, Timestamp nRegdate, int nhits) {
		super();
		this.setNotice_num(notice_num);
		this.nTitle = nTitle;
		this.nContent = nContent;
		this.nWriter = nWriter;
		this.nRegdate = nRegdate;
		this.nhits = nhits;
	}
	public NoticeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}


	



}
