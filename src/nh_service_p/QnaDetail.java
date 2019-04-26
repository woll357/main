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

public class QnaDetail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		CenterDTO dto = new CenterDTO();
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setAnswer("정보보기");
		CenterDAO dao = new CenterDAO();
		
		CenterDTO res = dao.qnaDetail(dto);
		request.setAttribute("dto", res);
		
		dao.close();
		

		if(res.getAnswer().equals("완료")) {
			CenterDTO dto2 = new CenterDTO();
			dto2.setId(((SignUpDTO) session.getAttribute("mem")).getId());
			dto2.setNum(Integer.parseInt(request.getParameter("num")));
			dto2.setAnswer("완료");
			CenterDAO dao2 = new CenterDAO();
			
			
			request.setAttribute("dto2", dao2.qnaDetail(dto2));
			
			dao2.close();
			
		}
		
		
		
		return null;
	}

}
