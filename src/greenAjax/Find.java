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
			
			HttpSession session = request.getSession();
			
			
			if(new SignUpDAO().chkMem(dto) && !dto.getId().equals(((SignUpDTO) session.getAttribute("mem")).getId())) {
				request.setAttribute("dto", new SignUpDAO().detailMem(dto));
				
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("goUrl", "../greensc/MgPage?mgpage=in");
					request.setAttribute("msg", "No1");
					request.setAttribute("mainUrl", "greensc/alert.jsp");
				}else if(dto.getId().equals(((SignUpDTO) session.getAttribute("mem")).getId())) {
					request.setAttribute("goUrl", "../greensc/ModifyMem?mypage=in");
					request.setAttribute("msg", "No2");
					request.setAttribute("mainUrl", "greensc/alert.jsp");
				}

			

			//response.getWriter().append("Served at: ").append(""+new SignUpDAO().detailMem(dto));

		
		return null;
	}

}
