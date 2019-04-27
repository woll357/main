package purchase_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class DetailReserveInfo implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id =((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		new DetailReserveGo(id, request, response);
		
		return null;
	}

}
