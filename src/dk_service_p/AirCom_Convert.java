package dk_service_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.Airp_detailsDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class AirCom_Convert implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		new Airp_detailsDAO().airConvert();
		
		return null;
	}

}
