package nh_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.CenterDAO;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class MgGradeUp implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		request.setAttribute("airData", new SignUpDAO().gradeUpAirList());
		request.setAttribute("hotData", new SignUpDAO().gradeUpHotList());
		request.setAttribute("mgData", new SignUpDAO().gradeUpMgList());
		
		
		return null;
	}

}
