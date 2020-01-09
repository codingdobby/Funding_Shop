package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uc.ac.db.ProdVO;



public class ProjectDAO {
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

	public ArrayList<ProjectVO> getAll() {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<ProjectVO> botari = new ArrayList<ProjectVO>();

		connectDB();
		String SQL = "select p.project_num,p.ptitle,m.nickname,p.pdate,p.pVerify,p.ppic1,p.totMoney from project p, member_ m where  id_fk=id and pVerify=1 order by  p.regdate desc;";
		ProjectVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new ProjectVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				vo.setName(rs.getString("nickname"));
				vo.setPdate(rs.getString("pdate"));
				vo.setPpic1(rs.getString("ppic1"));
				vo.setTotMoney(rs.getInt("totMoney"));
				
				
				
				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}
/**************************************************/
	public ProjectVO getContent(int pnum) {
		connectDB();
		String SQL = "select p.project_num, p.ptitle, m.nickname, p.pcontent,p.pmoney,p.pdate,p.ppic1,p.totMoney from project p , member_ m  where project_num=?";// 회원인지 아닌지 구별
		ProjectVO vo = null;// ==>int a;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, pnum);
			

			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new ProjectVO();
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				vo.setName(rs.getString("nickname"));
				vo.setPcontent(rs.getString("pcontent"));
				vo.setPmoney(rs.getInt("pmoney"));
				vo.setPdate(rs.getString("pdate"));
				vo.setPpic1(rs.getString("ppic1"));
				vo.setTotMoney(rs.getInt("totMoney"));
			
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}
	
	public ProdVO getProd(int pnum) {
		connectDB();
		String SQL = "select prodCount,prodName,prodNum from reward where project_num_fk=?";// 회원인지 아닌지 구별
		ProdVO vo = null;// ==>int a;

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, pnum);
			

			rs = pstm.executeQuery(); // select 문 수행시
			// 결과 출력
			if (rs.next() == true) {
				vo = new ProdVO();
				vo.setProdCount(rs.getInt("prodCount"));
				vo.setProdName(rs.getString("prodName"));
				vo.setProdNum(rs.getInt("prodNum"));
				
		
			} else {

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return vo;

	}
	
	
	
	
	
	
	
	
	/************프로젝트 조회수*****************/
	
	public void phitUpdate(int pnum) {// 회원1명 DB에 등록

		connectDB();//

		String SQL = "update project set phit=phit+1 where project_num=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, pnum);

			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}

	/*********인기있는 상품 4개 가져오기****************************/
	public ArrayList<ProjectVO> getHitItem() {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<ProjectVO> botari = new ArrayList<ProjectVO>();

		connectDB();
		String SQL = "select * from project where pVerify=1  order by phit desc limit 4;";
		ProjectVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new ProjectVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				
				vo.setPdate(rs.getString("pdate"));
				vo.setPmoney(rs.getInt("pmoney"));
				vo.setPpic1(rs.getString("ppic1"));

				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}
	/********신상 4개 가져오기****************************/
	public ArrayList<ProjectVO> getNewItem() {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<ProjectVO> botari = new ArrayList<ProjectVO>();

		connectDB();
		String SQL = "select * from project where pVerify=1 order by regdate desc limit 3;";
		ProjectVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new ProjectVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				
				vo.setPdate(rs.getString("pdate"));
				vo.setPmoney(rs.getInt("pmoney"));
				vo.setPpic1(rs.getString("ppic1"));
				
		
				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}
	/************프로젝트 장바구니 추가*****************/
	public void addCart(String id_fk ,int project_num_fk,int prodNum_fk) {

		connectDB();//

		String SQL = "insert into cart(id_fk,project_num_fk,prodNum_fk,amount) values(?,?,?,1)";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, id_fk);
			pstm.setInt(2, project_num_fk);
			pstm.setInt(3, prodNum_fk);
	
			
			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	/************프로젝트 장바구니 갯수 줄이기*****************/
	public void minusProduct(int prodNum) {

		connectDB();//

		String SQL = "update reward set prodCount=prodCount-1   where prodNum=?";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, prodNum);
	
			
			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	/************프로젝트 장바구니 갯수 줄이기*****************/
	public void plusMoney(int projectNum) {

		connectDB();//

		String SQL = "update project p , reward r set p.pmoney=p.pmoney+r.prodPrice where r.project_num_fk=p.project_num and p.project_num=?;";

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setInt(1, projectNum);
			
			
			pstm.executeUpdate(); // insert, update, delete 문에 사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	/************프로젝트 검색*****************/
	
	public ArrayList<ProjectVO> search(String ptitle) {// namecard table에 있는 모든 레코드를 넘겨줌
		ArrayList<ProjectVO> botari = new ArrayList<ProjectVO>();

		connectDB();
		String SQL = "select * from project where pVerify=1 and ptitle=? order by regdate desc;";
		ProjectVO vo = null;// 결과를 담는 그릇 객체

		try {
			pstm = conn.prepareStatement(SQL);
			pstm.setString(1, ptitle);
			rs = pstm.executeQuery(); // select 문 수행 결과가 rs 테이블에 다 담겨져 있음

			// rs 테이블의 모든 레코드를 botari에 담는다
			while (rs.next() == true) {

				vo = new ProjectVO();// 1개의 레코드를 담을 빈그릇(vo)을 준비
				vo.setProject_num(rs.getInt("project_num"));
				vo.setPtitle(rs.getString("ptitle"));
				vo.setPdate(rs.getString("pdate"));
				vo.setTotMoney(rs.getInt("totMoney"));
				vo.setPpic1(rs.getString("ppic1"));
				
		
				botari.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		closeDB();
		return botari;
	}
	
	
}
