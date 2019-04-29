package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_dereDAO;
import db_p.Air_dereDTO;
import di.MvcAction;
import di.MvcForward;
import payment_p.ModifyBstatusByAir_code;
import payment_p.ModifyBstatusByhcode;

public class Air_DeleteRequestDelete implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub'
		
		
		System.out.println("삭제 요청 목록 삭제");
		
		
		Air_dereDTO dto = new Air_dereDTO();
		
		Air_dereDAO dao = new Air_dereDAO();
		
		String code = request.getParameter("code");
		
		if(code.substring(0, 1).equals("H")) {
			new ModifyBstatusByhcode(code);
		}
		else if(code.substring(0, 1).equals("A")) {
			new ModifyBstatusByAir_code(code);
		}

		System.out.println(code);
		dao.delete(code);
		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("goUrl", "AirManagerHome");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		return null;
	}

}
