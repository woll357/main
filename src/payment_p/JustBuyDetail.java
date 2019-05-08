package payment_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import di.MvcAction;
import di.MvcForward;

public class JustBuyDetail implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ArrayList<BasketpaidDTO> adtos = new ArrayList<BasketpaidDTO>();
		ArrayList<BasketpaidDTO> hdtos = new ArrayList<BasketpaidDTO>();

		String [] basketIDs = (String[]) request.getSession().getAttribute("basketIDs");
		
		int totalPrice = 0;
		
		for (int j = 0; j < basketIDs.length; j++) {
			BasketpaidDTO jbdto = new BasketpaidDTO();
				jbdto.setBasketID(basketIDs[j]);
			jbdto = new BasketpaidDAO().detail(jbdto);
			totalPrice += jbdto.getTotalPrice();
		}
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("hdtos",hdtos);
		request.setAttribute("adtos",adtos);
		request.getSession().removeAttribute("basketIDs");
		
		return null;
		
		
	}

}
