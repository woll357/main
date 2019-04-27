package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class HlistSearch implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Hot_comDTO dto = new Hot_comDTO();
		dto.setHcode(request.getParameter("hcode"));
		
		request.setAttribute("data", new Hot_tempDAO().hotelsearch(dto));

		System.out.println("방검색!");
		
		return null;
	}

}
