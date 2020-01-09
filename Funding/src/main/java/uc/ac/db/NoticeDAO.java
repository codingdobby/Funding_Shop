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





@Component
public class NoticeDAO {

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

	/**************************************************************************/

	public NoticeVO getContent(int no) {
		connectDB();
		String SQL = "select * from notice where notice_num=?";// 회원인지 아닌지 구별
		NoticeVO vo = null;// ==>int a;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, no);
			

			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new NoticeVO();
				vo.setNotice_num(rs.getInt("notice_num"));
				vo.setnTitle(rs.getString("nTitle"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnWriter(rs.getString("nWriter"));
				vo.setnRegdate(rs.getTimestamp("nRegdate"));
				vo.setNhits(rs.getInt("nhits"));
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}
	

	/**************************************************************************/
	public void hitUpdate(int no) {// 회원1명 DB에 등록

		connectDB();//

		String SQL = "update notice set nhits=nhits+1 where notice_num=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, no);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	

	/**************************************************************************/
	public ArrayList<NoticeVO> getAll() {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<NoticeVO> botari = new ArrayList<NoticeVO>();

		connectDB();
		String SQL = "select * from notice order by notice_num desc;";
		NoticeVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new NoticeVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setNotice_num(rs.getInt("notice_num"));
				vo.setnTitle(rs.getString("nTitle"));
				vo.setnWriter(rs.getString("nWriter"));
				vo.setnContent(rs.getString("nContent"));
				vo.setnRegdate(rs.getTimestamp("nRegdate"));
				vo.setNhits(rs.getInt("nhits"));

				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}

	/**************************************************************************/
	/**************************************************************************/
	/**************************************************************************/
	/**************************************************************************/
	
	
	
	
	/**************************************************************************/
	
	public void noticeInsert(String ntitle,String nContent, String nWriter)   {

		connectDB();//

		String SQL = "insert into notice(nTitle, nContent, nWriter) values(?,?,?)";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, ntitle);
			pstm.setString(2, nContent);// tel);
			pstm.setString(3, nWriter);// company);
			
			

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	/**************************************************************************/
	
	public void projectInsert(String ptitle,int pcategory,String pcontent,int pmoney,
			String pwriter,String pdate, String ppic) {// 회원1명 DB에 등록

		connectDB();//

		String SQL = "insert into project(ptitle,pcategory,pcontent,pmoney,\r\n" + 
				"			pwriter,pdate, ppic1) values(?,?,?,?,?,?,?)";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, ptitle);
			pstm.setInt(2, pcategory);// tel);
			pstm.setString(3, pcontent);// company);
			pstm.setInt(4, pmoney);
			pstm.setString(5, pwriter);// tel);
			pstm.setString(6, pdate);// company);
			pstm.setString(7, ppic);
			
			
			

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	
	
	
	
}
