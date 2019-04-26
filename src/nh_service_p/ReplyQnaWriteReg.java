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

public class ReplyQnaWriteReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("답변 작성 진입");
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			HttpSession session = request.getSession();
			
		
	         CenterDTO dto = new CenterDTO();
	         dto.setTitle(request.getParameter("title"));
	         dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
	         dto.setContent(request.getParameter("content"));
	         dto.setQnum(Integer.parseInt(request.getParameter("qnum")));
	         dto.setNum(Integer.parseInt(request.getParameter("num")));

	       
	         int num = new CenterDAO().qnaReplyWrite(dto);
	         
	        request.setAttribute("msg", "작성되었습니다.");
	        request.setAttribute("goUrl", "QnaDetail?num="+num);
	        request.setAttribute("mainUrl", "greensc/alert.jsp");
		
		return null;
	}

}
