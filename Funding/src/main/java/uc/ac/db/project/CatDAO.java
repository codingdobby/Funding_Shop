package uc.ac.db.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class CatDAO {
	

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
	
	/************************************************************************************/
	public ArrayList<CatVO> getCat() {
		ArrayList<CatVO> Cat = new ArrayList<CatVO>();

		connectDB();
		String SQL = "select category_name from category order by category_id;";
		CatVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new CatVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setCategory_name(rs.getString("category_name"));
				

				Cat.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return Cat;
	}
}
