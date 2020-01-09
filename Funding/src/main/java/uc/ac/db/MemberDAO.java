package uc.ac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import projectDB.ProjectVO;

@Component // MemberDAO 클래스로 부터 객체(memberDAO)를 생성해서 빈으로 컨테이너에 등록 시킴
public class MemberDAO {

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

	public void join(MemberVO vo) {// 회원1명 DB에 등록

		connectDB();//

		String SQL = "insert into member_(nickname, id, pwd, phone, address) values(?,?,?,?,?)";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, vo.getNickname());
			pstm.setString(2, vo.getId());// tel);
			pstm.setString(3, vo.getPwd());// company);
			pstm.setString(4, vo.getPhone());// company);
			pstm.setString(5, vo.getAddress());// company);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	/************** 회원인지 확인 *******************************************************/
	public MemberVO checkMember(String id, String pwd) {
		connectDB();
		String SQL = "select * from member_ where id=? and pwd=?";// 회원인지 아닌지 구별
		MemberVO vo = null;// ==>int a;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id);
			pstm.setString(2, pwd);

			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new MemberVO();
				vo.setNickname(rs.getString("nickname"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setVerify(rs.getInt("verify"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));

			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}

	// 로그인 체크
	public boolean loginCheck(String id, String pwd) {
		boolean check = false;
		connectDB();
		String SQL = "select * from member_ where id=? and pwd=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id); 
			pstm.setString(2, pwd);

			rs = pstm.executeQuery();// select문 수행시 사용 => table결과 보여줌

			// 결과출력
			if (rs.next() == true) {// rs.next() => 커서 한칸 밑으로 옮김
				check = true;  //일치하는 값이 존재하면  true 

			} else {
				check = false;  //일치하는 값이 없으면  false 
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} // 공식

		closeDB();
		return check;//check값 반환
	}

	
	
	
	// ******************************
	public ArrayList<MemberVO> getAll() {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<MemberVO> botari = new ArrayList<MemberVO>();

		connectDB();
		String SQL = "select * from member_";
		MemberVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {
				vo = new MemberVO();
				vo = new MemberVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setNickname(rs.getString("nickname"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				vo.setVerify(rs.getInt("verify"));
				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}

	/**************
	 * verify값 가져오기
	 *******************************************************/
	public ArrayList<MemberVO> getVerify() {//
		ArrayList<MemberVO> verify = new ArrayList<MemberVO>();

		connectDB();
		String SQL = "select * from member_";
		MemberVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new MemberVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비

				vo.setVerify(rs.getInt("verify"));
				verify.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return verify;
	}

	/******************* 삭제 *******************************/

	public void delete(String id) {

		connectDB();//

		String SQL = "delete from member_ where id=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	/************** 비밀번호 관련 기능 **************************************/

	public MemberVO checkID(String checkid) {
		connectDB();
		String SQL = "select * from member_ where id=?";// 회원인지 아닌지 구별
		MemberVO vo = null;//

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, checkid);

			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}

	/********************* 마이페이지에서 값 수정 ****************************/
	public void updateInfo(String nickname, String pwd, String phone, String address, String id) {// 회원1명 DB에 등록

		connectDB();//

		String SQL = "update member_ set nickname=?, pwd=?,phone=?, address=? where id=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, nickname);
			pstm.setString(2, pwd);
			pstm.setString(3, phone);
			pstm.setString(4, address);
			pstm.setString(5, id);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	/********************* 비밀번호 재설정 ****************************/

	public void updatePwd(String pwd, String checkid) {//

		connectDB();//

		String SQL = "update member_ set pwd=? where id=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, pwd);
			pstm.setString(2, checkid);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

//*************************************************************************/
		public ArrayList<CartVO> getCart(String id_fk) {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<CartVO> botari = new ArrayList<CartVO>();

		connectDB();
		String SQL = "select c.id_fk, r.prodName, p.ptitle,count(amount) amount ,r.prodPrice*count(amount) price from cart c,project p, reward r where c.id_fk=? and p.project_num=c.project_num_fk\r\n" + 
				"and c.prodNum_fk=r.prodNum group by c.project_num_fk" + 
				";";
		CartVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id_fk);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음
			

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {
				vo = new CartVO();
				vo.setId_fk(rs.getString("id_fk"));
				vo.setProdName(rs.getString("prodName"));
				vo.setAmount(rs.getInt("amount"));
				vo.setPrice(rs.getInt("price"));
				vo.setPtitle(rs.getString("ptitle"));
				
				
				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}



}
