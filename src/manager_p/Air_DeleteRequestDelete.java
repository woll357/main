package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_dereDAO;
import db_p.Air_dereDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
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

			Hot_comDTO hdto = new Hot_comDTO();
			hdto.setHcode(code);
			hdto = new Hot_tempDAO().detail2(hdto);
			SignUpDTO sdto = new SignUpDTO();
			sdto.setId(hdto.getId());
			sdto.setGrade("H");
			new SignUpDAO().deleteId(sdto);
			
		}
		else if(code.substring(0, 1).equals("A")) {
			new ModifyBstatusByAir_code(code);
			
			Air_comDTO adto = new Air_comDTO();
			adto.setAir_code(code);
			adto = new Air_comDAO().serarchByAirCode(adto);
			
			SignUpDTO sdto = new SignUpDTO();
			sdto.setId(adto.getId());
			new SignUpDAO().deleteId(sdto);
		}

		System.out.println(code);
		dao.delete(code);

		
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("goUrl", "AirManagerHome");
		request.setAttribute("mainUrl", "air/alert.jsp");
		
		return null;
	}

}
