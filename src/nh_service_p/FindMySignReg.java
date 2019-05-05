package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class FindMySignReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String arr [] = request.getParameterValues("phone");
		String phone =arr[0]+"-"+arr[1]+"-"+arr[2];
		
		SignUpDTO dto = new SignUpDTO();
		dto.setId(request.getParameter("id"));
		dto.setPhone(phone);
		
		
		
		
		String me = null;
		
		
		if(request.getParameter("id")!=null) {
			if(new SignUpDAO().findPw(dto)!=null) {
				me="PW : "+(String)new SignUpDAO().findPw(dto)+" 입니다.";
			}else {
				me="존재하지 않는 계정 입니다.";
			}
		}else {
			if(new SignUpDAO().findId(dto)!=null) {
			me="ID : "+(String)new SignUpDAO().findId(dto)+" 입니다.";
			}else {
				me="존재하지 않는 계정 입니다.";
			}
		}
		
		
		request.setAttribute("msg", me);
        request.setAttribute("goUrl", "FindMySign");
        request.setAttribute("mainUrl", "greensc/alert.jsp");
		
		return null;
	}

}
