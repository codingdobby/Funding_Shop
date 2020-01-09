package uc.ac.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import projectDB.ProjectVO;

@Component
public class UploadDAO {

	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null; // select문 수행후 결과를 저장하는 객체

	public void connectDB() {
		try {
			// String dbURL = "jdbc:mysql://localhost:3306/BBS"; //MySQL 5.xx 까지 사용
			String dbURL = "jdbc:mysql://localhost:8050/sp51712124?serverTimezone=UTC";

			String dbID = "spring5";
			String dbPassword = "spring5";

			// jdbc 드라이브 로딩
			// Class.forName("com.mysql.jdbc.Driver"); //MySQL 5.xx 까지 사용
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB 연결
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

			System.out.println("DB 연결 OK");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}

	public void closeDB() {
		try {
			if (pstm != null)
				pstm.close();
			if (rs != null)
				rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/******************관리자용 프로젝트 전체보기 **************************************/
	public ArrayList<UploadVO> projectALL() {//
		ArrayList<UploadVO> botari = new ArrayList<UploadVO>();

		connectDB();
		

		String SQL = "select p.project_num,p.ptitle,m.nickname,p.regdate,p.pVerify from project p, member_ m where  id_fk=id order by  p.regdate desc;";

		UploadVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
		
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			
			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new UploadVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				vo.setName(rs.getString("nickname"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setpVerify(rs.getInt("pVerify"));

				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}
	
	/************************관리자 승인 기능**************************************************/

	public void admit(String pnum) {

		connectDB();//

		String SQL = "update project set pVerify=1 where project_num=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, pnum);
			
		
			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	
	
	
	
	/**************************************************************************/
	
	
	
	
	
	/**************************************************************************/

	public ArrayList<UploadVO> getAll(String id_fk) {//
		ArrayList<UploadVO> botari = new ArrayList<UploadVO>();

		connectDB();
		String SQL = "select p.project_num,p.ptitle,m.nickname,p.regdate,p.pVerify from project p, member_ m where id_fk=? and id_fk=id order by  p.regdate desc";

		UploadVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id_fk);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			
			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new UploadVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				vo.setName(rs.getString("nickname"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setpVerify(rs.getInt("pVerify"));

				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}

	/**************************************************************************/
	
	public void insertproj(String ptitle, String pcontent, int totMoney,String id_fk, String pdate, String ppic1) {

		connectDB();//

		String SQL = "insert into project(ptitle, pcontent, totMoney,id_fk, pdate,ppic1) values(?,?,?,?,?,?)";

		try {
			
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, ptitle);
			pstm.setString(2, pcontent);
			pstm.setInt(3, totMoney);
			pstm.setString(4, id_fk);
			pstm.setString(5, pdate);
			pstm.setString(6, ppic1);
			
			
			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}


	///////////////////////////////////////////////////////////////////////////////
	/*************************상품 넣기*****************************************************/
	public void insertRew(int project_num_fk,String prodName,int prodPrice, int prodCount) {

		connectDB();//

		String SQL = "insert into reward(project_num_fk,prodName, prodPrice, prodCount) values(?,?,?,?)";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, project_num_fk);
			pstm.setString(2, prodName);
			pstm.setInt(3, prodPrice);
			pstm.setInt(4, prodCount);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	
	/*************************상품 넣기 end*****************************************************/
	/***********************fk에 넣을 기본키 가져오기***************************************************/
	
	public UploadVO getPnum(String id_fk) {
		connectDB();
		String SQL = "select project_num from project where id_fk=?";// 회원인지 아닌지 구별
		UploadVO vo = null;// ==>int a;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id_fk);


			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new UploadVO();
				vo.setProject_num(rs.getInt("project_num"));
			
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}
	
	
	public ProdVO getRewId(String pwriter) {
		connectDB();
		String SQL = "select prodNum from reward where pwriter=?";// 회원인지 아닌지 구별
		ProdVO vo = null;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, pwriter);


			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new ProdVO();
				vo.setProdNum(rs.getInt("prodNum"));
			
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}
	
	
	
	
	
	
	/***********************fk에 넣을 기본키 가져오기***************************************************/
	
	/*************************프로젝트 정보*****************************************************/
	public void insertinfo(int pnum, String id_fk,int reward) {

		connectDB();//

		String SQL = "insert into personal_project(project_num_fk,id_fk  prodNum_fk) values(?,?,?)";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, pnum);
			pstm.setString(2, id_fk);
			pstm.setInt(3, reward);


			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	/*************************프로젝트 정보 end*****************************************************/
	
	
	
	
	public UploadVO getProject_fk(String ptitle , String id) {
		connectDB();
		String SQL = "select project_num from project where ptitle=? and id_fk=?;";// 회원인지 아닌지 구별
		UploadVO vo = null;// ==>int a;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, ptitle);
			pstm.setString(2, id);

			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new UploadVO();
				vo.setProject_num(rs.getInt("project_num"));
				
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}

	


}
