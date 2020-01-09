package uc.ac.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {

		HttpSession session = req.getSession();
		//controller에서 세션에 verify설정 한 값 불러오기
		int verify = (int)session.getAttribute("verify");
		
		if (verify!=9) {//일반 사용자
			res.sendRedirect("/funding/main.do");
			return false;			
		}

		return true;//관리자

	}
}