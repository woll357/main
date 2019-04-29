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
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("phone"));
		
		SignUpDTO dto = new SignUpDTO();
		dto.setId(request.getParameter("id"));
		
		
		new SignUpDAO().chkMem(dto);
		
		
		return null;
	}

}
