package purchase_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class RefundList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id =((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		BasketpaidDTO bpdto = new BasketpaidDTO();
		
		bpdto.setId(id);
		
		ArrayList<BasketpaidDTO> bpdtos = new BasketpaidDAO().myRefundList(bpdto); 
		
		request.setAttribute("bpdtos",bpdtos);
		request.setAttribute("mainUrl", "purchase/RefundList.jsp");
		
		
		return null;
	}

}
