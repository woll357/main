package payment_p;

import java.util.Date;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
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
		bpdto = new BasketpaidDAO().detail(bpdto);
		
		if(bpdto.getcType().equals("A")){
			Air_itemDTO aidto = new Air_itemDTO();
			aidto.setCcode(bpdto.getCode());
			aidto.setSeatcnt(-bpdto.getPsn());
			new Air_itemDAO().update_seatcnt(aidto);
		}
		
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
