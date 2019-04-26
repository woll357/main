package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class LogOut implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		session.invalidate();

		request.setAttribute("msg", "로그아웃 하셨습니다.");
		request.setAttribute("mainUrl", "greensc/alert.jsp");
		request.setAttribute("goUrl", "Login");
		
		return null;
	}

}
