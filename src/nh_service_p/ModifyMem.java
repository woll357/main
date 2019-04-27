package nh_service_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.CenterDTO;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class ModifyMem implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		HttpSession session = request.getSession();
		SignUpDTO dto = new SignUpDTO();
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		
		new SignUpDAO().detailMem(dto);
		request.setAttribute("dto", new SignUpDAO().detailMem(dto));
		
		
		
		return null;
	}

}
