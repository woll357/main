package purchase_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

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
		String id =  ((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		BasketpaidDTO bpdto = new BasketpaidDTO();
		BasketItemDTO bidto = new BasketItemDTO();
		BuyDTO bdto = new BuyDTO();
		
		bpdto.setBasketID(basketID);
		
		new BasketpaidDAO().detail(bpdto);
		bdto.setBcode(bpdto.getBcode());
		bdto.setBstatus("r");
		
		bpdto.setBstatus("r");
		bidto.setBasketID(basketID);
		bidto.setBstatus("r");
		
		new BuyDAO().modifyBstatus(bdto);
		new BasketpaidDAO().modifyBstatus(bpdto);
		new BasketItemDAO().modifyBstatus(bidto);
		
		new DetailReserveGo(id, request, response);
		
		return null;
	}

}
