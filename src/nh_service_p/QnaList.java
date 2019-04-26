package nh_service_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.CenterDAO;
import db_p.CenterDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class QnaList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();		
		CenterDTO dto = new CenterDTO();
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		dto.setGrade(((SignUpDTO) session.getAttribute("mem")).getGrade());
		
		request.setAttribute("data", new CenterDAO().qnaList(dto));
		
		return null;
	}

}
