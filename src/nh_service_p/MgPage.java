package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class MgPage implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub.
		
		
		SignUpDTO dto = new SignUpDTO();
		request.setAttribute("memNum", new SignUpDAO().memNum(dto));
		
		return null;
	}

}
