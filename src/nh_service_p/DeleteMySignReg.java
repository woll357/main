package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class DeleteMySignReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		SignUpDTO dto = new SignUpDTO();
		String str;
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		dto.setPw(request.getParameter("pw"));
		dto.setGrade(((SignUpDTO) session.getAttribute("mem")).getGrade());
		
		
		if(new SignUpDAO().chklogin(dto)==null) {
			str = "PW 확인 부탁드립니다.";
			request.setAttribute("msg", str);
	        request.setAttribute("goUrl", "DeleteMySign");
	        request.setAttribute("mainUrl", "greensc/alert.jsp");
		}else if(request.getParameter("agree")==null) {
			str = "동의 확인 부탁드립니다.";
			request.setAttribute("msg", str);
	        request.setAttribute("goUrl", "DeleteMySign");
	        request.setAttribute("mainUrl", "greensc/alert.jsp");
		}else if(new SignUpDAO().chklogin(dto)!=null && 
			request.getParameter("agree").equals("true")) {
			new SignUpDAO().deleteId(dto);
			str = "이용해 주셔서 감사합니다.";
			request.setAttribute("msg", str);
	        request.setAttribute("goUrl", "Home");
	        request.setAttribute("mainUrl", "greensc/alert.jsp");
	        session.invalidate();
		}
		
		
		return null;
	}

}
