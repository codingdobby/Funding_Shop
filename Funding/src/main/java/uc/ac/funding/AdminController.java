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

import projectDB.ProjectVO;
import uc.ac.db.MemberDAO;
import uc.ac.db.MemberVO;
import uc.ac.db.UploadDAO;
import uc.ac.db.UploadVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	@Autowired
	private UploadDAO uploadDAO;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/Admin")
	public String Admin(HttpServletRequest request, Model model) {// id,pwd확인
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberVO> memBotari = memberDAO.getAll();

		model.addAttribute("MemberList", memBotari);

		return "/Admin/adminMain";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {// id,pwd확인
		MemberDAO memDAO = new MemberDAO();

		String id = request.getParameter("id");

		memDAO.delete(id);

		return "redirect:Admin";
	}

	@RequestMapping("/AdminProject")
	public String AdminProject(HttpServletRequest request, Model model) {// id,pwd확인

		ArrayList<UploadVO> ProjectBotari = uploadDAO.projectALL();

		model.addAttribute("ProjectList", ProjectBotari);

		return "Admin/AdminProject";
	}

	/************************* 버튼으로 승인하는 기능 *************************************/
	@RequestMapping("/admit")
	public String admit(HttpServletRequest request, Model model) {// id,pwd확인
		UploadDAO upDAO = new UploadDAO();

		String pnum = request.getParameter("pnum");

		upDAO.admit(pnum);

		return "redirect:AdminProject";
	}

}
