package purchase_p;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;
import di.MvcAction;
import di.MvcForward;
import payment_p.ChangeBstatus;

public class RefundReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String basketID = request.getParameter("basketID");
		System.out.println("내가 선택한 상품"+basketID);
		String id = "1112"; //= ((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		String bstatus = "r";
		
		new ChangeBstatus(basketID, bstatus);
		
		new DetailReserveGo(id, request, response);
		
		return null;
	}

}
