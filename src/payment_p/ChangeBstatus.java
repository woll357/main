package payment_p;

import java.util.Date;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;

public class ChangeBstatus {
	
	public ChangeBstatus(String basketID, String bstatus) {
		// TODO Auto-generated constructor stub
		
		BasketpaidDTO bpdto = new BasketpaidDTO();
		BasketItemDTO bidto = new BasketItemDTO();
		BuyDTO bdto = new BuyDTO();
		
		bpdto.setBasketID(basketID);
		new BasketpaidDAO().detail(bpdto);
		bidto.setBasketID(basketID);
		bdto.setBasketID(basketID);
		
		bdto.setBstatus(bstatus);
		bidto.setBstatus(bstatus);
		bpdto.setBstatus(bstatus);
		
		Date now = new Date();
		bdto.setBdate(now);
		
		new BuyDAO().modifyBD(bdto);
		new BasketpaidDAO().modifyBstatus(bpdto);
		new BasketItemDAO().modifyBstatus(bidto);
		
	}
}
