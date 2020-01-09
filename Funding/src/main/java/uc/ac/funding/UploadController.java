package uc.ac.funding;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import projectDB.ProjectDAO;
import projectDB.ProjectVO;
import uc.ac.db.MemberDAO;
import uc.ac.db.MemberVO;
import uc.ac.db.PhotoVO;
import uc.ac.db.ProdVO;
import uc.ac.db.UploadDAO;
import uc.ac.db.UploadVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class UploadController {
	@Autowired
	private UploadDAO uploadDAO;

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/upload")
	public String UploadMain(HttpServletRequest request, Model model) {// id,pwd확인

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		ArrayList<UploadVO> boardBotari = uploadDAO.getAll(id);

		model.addAttribute("boardList", boardBotari);

		return "/Upload/UploadList";
	}

	@RequestMapping("/go_insertProd")
	public String go_insertProd(HttpServletRequest request, Model model) {// id,pwd확인
	
		return "/Upload/UploadMain";
	}

	@RequestMapping("/insertProd")
	public String insertProd(HttpServletRequest request, @RequestParam("ppic1") MultipartFile ppic1, Model model) {// id,pwd확인

		String ptitle = request.getParameter("ptitle");
		String pcontent = request.getParameter("pcontent");
		String pdate = request.getParameter("pdate");

		int totMoney = Integer.parseInt(request.getParameter("totMoney"));

		HttpSession session = request.getSession();
		String id_fk = (String) session.getAttribute("id");

		/**********************************************************/
		String savePath = "F:\\3-1\\ChallengeProject\\ws\\Funding\\src\\main\\webapp\\resources\\photoUpload";

		String originalFilename = ppic1.getOriginalFilename(); // fileName.jpg
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
		String extension = originalFilename.substring(originalFilename.indexOf(".")); // .jpg

		String rename = onlyFileName + extension; // fileName_20150721-14-07-50.jpg
		String fullPath = savePath + "\\" + rename;

		if (!ppic1.isEmpty()) {
			try {
				byte[] bytes = ppic1.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
				model.addAttribute("resultMsg", "파일을 업로드 성공!");
				System.out.println("성공");
			} catch (Exception e) {
				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
				System.out.println("실패");
			}
		} else {
			model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}

		/**********************************************************/
		UploadDAO upDAO = new UploadDAO();
		// 프로젝트 정보 저장
		upDAO.insertproj(ptitle, pcontent, totMoney, id_fk, pdate, originalFilename.trim());

		UploadVO find = upDAO.getProject_fk(ptitle, id_fk);

		if (find != null) {// 회원
			System.out.println(find.getProject_num() + "번호^^");

			session.setAttribute("project_num_fk", find.getProject_num());
		} else {

			System.out.println("널값 ㅜㅜ");
		}
		/**********************************************************/

		return "Upload/UploadProd";
	}

	@RequestMapping("/insert_OK")
	public String insert_OK(HttpServletRequest request, Model model) {// id,pwd확인
		UploadDAO upDAO = new UploadDAO();

		HttpSession session = request.getSession();
		int project_num_fk = (int) session.getAttribute("project_num_fk");

		String prodName = request.getParameter("prodName");
		int prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
		int prodCount = Integer.parseInt(request.getParameter("prodCount"));
		// 상품 저장
		upDAO.insertRew(project_num_fk, prodName, prodPrice, prodCount);

		session.removeAttribute("project_num_fk");

		return "redirect:upload";
	}

}
