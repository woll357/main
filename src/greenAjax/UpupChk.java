package greenAjax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class UpupChk implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		
		HttpSession session = request.getSession();
		SignUpDTO dto = new SignUpDTO();
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		dto.setGrade(request.getParameter("grade"));
		dto.setBnum(request.getParameter("bnum"));
		dto.setCrn(request.getParameter("crn"));
		
		System.out.println("중복체크 합니다."+new SignUpDAO().chkApply(dto));

		if (new SignUpDAO().chkApply(dto)) {
			
			request.setAttribute("msg", "중복");
			
		} else {

			if (new SignUpDAO().chkempty(dto)) {
				request.setAttribute("msg", "환불");
				
			} else {

				
				request.setAttribute("msg", "승인");
				
			}
		}
		return null;
	}

}
