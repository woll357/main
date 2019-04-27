package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_dereDAO;
import db_p.Air_dereDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirLine_DeleteRequestReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		System.out.println("항공사 삭제 신청 insert");
		
		Air_dereDTO dto = new Air_dereDTO();
		
		System.out.println(request.getParameter("code"));
		
		dto.setCode(request.getParameter("code"));
		dto.setRequest(request.getParameter("request"));
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		dto.setKind(request.getParameter("kind"));
		
		new Air_dereDAO().insert(dto);
		
		request.setAttribute("msg","요청되었습니다.");
		request.setAttribute("goUrl", "AirHomeMain");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		return null;
	}

}
