package uc.ac.funding;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uc.ac.db.NoticeDAO;
import uc.ac.db.NoticeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NoticeController {
	@Autowired
	private NoticeDAO noticeDAO;

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/notice")
	public String notice(HttpServletRequest request, Model model) {// id,pwd확인

		ArrayList<NoticeVO> boardBotari = noticeDAO.getAll();

		model.addAttribute("boardList", boardBotari);

		return "/Notice/NoticeList";
	}

	@RequestMapping("/listContent.do") // 상세내용
	public String listContent(HttpServletRequest request, Model model) {// id,pwd확인

		int no = Integer.parseInt(request.getParameter("no"));

		NoticeVO vo = noticeDAO.getContent(no);// board테이블에서 no값 primary key로 해서 가져오기
		noticeDAO.hitUpdate(no);
		model.addAttribute("vo", vo);

		return "/Notice/NoticeContent";
	}

	
	@RequestMapping("/go_noticeWrite.do") // 글쓰기 이동
	public String go_noticeWrite(HttpServletRequest request) {// id,pwd확인

	

		return "/Notice/NoticeWrite";
	}

	
	
	@RequestMapping("noticeOK.do") // 글쓰기 기능
	public String noticeOK(HttpServletRequest request, Model model) {// id,pwd확인

		HttpSession session = request.getSession();

		String ntitle = request.getParameter("nTitle");
		String nWriter = (String)session.getAttribute("name");
		String nContent = request.getParameter("nContent");

		noticeDAO.noticeInsert(ntitle,nContent,nWriter);// DB에 입력받은 회원정보(vo)를 저장

		return "redirect:notice";
	}

}
