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

import projectDB.ProjectDAO;
import projectDB.ProjectVO;
import uc.ac.db.NoticeVO;
import uc.ac.db.ProdVO;
import uc.ac.db.project.CatDAO;
import uc.ac.db.project.CatVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProjectController {

	@Autowired
	private CatDAO catDAO;

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/project")
	public String Project(HttpServletRequest request, Model model) {// id,pwd확인

		ArrayList<CatVO> CatList = catDAO.getCat();
		model.addAttribute("CatList", CatList);
		ProjectDAO projectDAO = new ProjectDAO();

		ArrayList<ProjectVO> boardBotari = projectDAO.getAll();

		
		model.addAttribute("projectBotari", boardBotari);
		
		
		return "/Project/ProjectMain";
	}

	@RequestMapping("/fundDetail")
	public String Project_main(HttpServletRequest request, Model model) {// id,pwd확인
		ProjectDAO projectDAO = new ProjectDAO();
		
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		ProjectVO vo = projectDAO.getContent(pnum);// board테이블에서 no값 primary key로 해서 가져오기
		
		projectDAO.phitUpdate(pnum);
		
		
		ProdVO count = projectDAO.getProd(pnum);
		model.addAttribute("vo", vo);
		model.addAttribute("count", count);
		
		

		return "/Project/ProjectContent";
	}
	
	
	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request, Model model) {// id,pwd확인
		 HttpSession session = request.getSession();
		String id_fk=(String)session.getAttribute("id");
		int ProdNum_fk=Integer.parseInt(request.getParameter("prodNum_fk")); ;
		int Project_Num_fk= Integer.parseInt(request.getParameter("project_num_fk"));
		
		ProjectDAO pdao = new ProjectDAO();
		pdao.addCart(id_fk,Project_Num_fk,ProdNum_fk);
		//물건 갯수 줄이기
		pdao.minusProduct(ProdNum_fk);
		
		//가격 더하기
		pdao.plusMoney(Project_Num_fk);
		
		

		return "redirect:mycart";
	}

	
}
