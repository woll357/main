package greenAjax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class DupTest implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		SignUpDTO dto = new SignUpDTO();
		dto.setId(request.getParameter("id"));
		dto.setPhone(request.getParameter("phone"));
		System.out.println(request.getParameter("id")+"???");
		
		int cc=0;
		
		if(new SignUpDAO().chkMem(dto)) {
			request.setAttribute("msg", "아이디");
		}
		if(new SignUpDAO().chkPhone(dto)) {
			request.setAttribute("msg", "핸드폰");
		}
		if(request.getParameter("id")=="" || request.getParameter("phone")=="--") {
			request.setAttribute("msg", "공란");
		}
		if(!new SignUpDAO().chkMem(dto) && request.getParameter("id")!=null) {
			request.setAttribute("msg1", "id체크");
		}
		if(!new SignUpDAO().chkPhone(dto)) {
			request.setAttribute("msg2", "pp체크");
		}
		
		
		return null;
	}

}
