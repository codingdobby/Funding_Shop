package uc.ac.db;

public class MemberVO {
	private String nickname;
	private String id;
	private String pwd;
	private String phone;
	private String address;
	private int verify;

	public MemberVO(String nickname, String id, String pwd, String phone, String address, int verify) {
		super();
		this.nickname = nickname;
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.address = address;
		this.verify = verify;
	}

	public MemberVO(String nickname, String pwd, String phone, String address) {
		super();
		this.nickname = nickname;
		this.pwd = pwd;
		this.phone = phone;
		this.address = address;
	
	}

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

}
