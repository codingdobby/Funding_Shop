package uc.ac.funding;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.Session;

import uc.ac.db.CartVO;
import uc.ac.db.MemberDAO;
import uc.ac.db.MemberVO;
import uc.ac.db.NoticeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MyPageController {

	private static final Logger logger = LoggerFactory.getLogger(MyPageController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/mypage")
	public String Project(HttpServletRequest request) {// id,pwd확인

		return "/MyPage/MyPageMain";
	}

	@RequestMapping("/mypageProject")
	public String mypageProject(HttpServletRequest request) {// id,pwd확인

		return "/MyPage/MyPageProject";
	}

	@RequestMapping("/mypageUpdate")
	public String mypageUpdate(HttpServletRequest request) {// id,pwd확인
		String nickname = request.getParameter("nickname");// 아이디 값 가져오기
		String pwd = request.getParameter("pwd");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String id= request.getParameter("id");
		MemberDAO memDAO  = new MemberDAO();
		memDAO.updateInfo(nickname, pwd, phone, address, id);
				
		
		
/*
		MemberDAO memberDAO  = new MemberDAO();
		MemberVO vo = new MemberVO(name, pwd, phone, address);
	
		memberDAO.memberUpdate(vo);// DB에 입력받은 회원정보(vo)를 저장
			*/
		
		return "/MyPage/MyPageMain";
	}

	
	@RequestMapping("/mycart")
	public String mycart(HttpServletRequest request ,Model model) {// id,pwd확인
			//카트 테이블 설렉트값
		
		MemberDAO memberDAO  = new MemberDAO();
		HttpSession session = request.getSession();
		String id_fk = (String)session.getAttribute("id");
		ArrayList<CartVO> cartList = memberDAO.getCart(id_fk);

		model.addAttribute("cartList", cartList);
		
		
		
		
		return "/MyPage/MyCart";
	}
	
	
}
