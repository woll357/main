package greenAjax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Find implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	
			SignUpDTO dto = new SignUpDTO();
			dto.setId(request.getParameter("id"));
			System.out.println(new SignUpDAO().chkMem(dto));
			if(new SignUpDAO().chkMem(dto)) {
				request.setAttribute("dto", new SignUpDAO().detailMem(dto));
				
				}else {
					request.setAttribute("goUrl", "../greensc/MgPage?mgpage=in");
					request.setAttribute("msg", "No");
					request.setAttribute("mainUrl", "greensc/alert.jsp");
				}

			

			//response.getWriter().append("Served at: ").append(""+new SignUpDAO().detailMem(dto));

		
		return null;
	}

}
