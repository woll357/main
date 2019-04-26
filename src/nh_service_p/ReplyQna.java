package nh_service_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.CenterDAO;
import db_p.CenterDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class ReplyQna implements MvcAction {

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
		
		CenterDTO dto = new CenterDTO();
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setAnswer("대기");
		CenterDAO dao = new CenterDAO();
		
		request.setAttribute("dto", dao.qnaDetail(dto));
		
		dao.close();
		
		return null;
	}

}
