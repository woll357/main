package payment_p;

import java.util.ArrayList;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;

public class ModifyBstatusByhcode {

	public ModifyBstatusByhcode(String hcode) {
		// TODO Auto-generated constructor stub
		
		Room_itemDTO ridto = new Room_itemDTO();
		ridto.setHcode(hcode);
		ArrayList<Room_itemDTO> ridtos = (ArrayList<Room_itemDTO>) new Hot_tempDAO().roomlist(ridto);
		String bstatus= "r";
		
		for (Room_itemDTO rr : ridtos) {
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(rr.getRcode());
			ArrayList<BasketItemDTO> bidtos = new BasketItemDAO().basketIDListByRcode(bidto);
			
			for (BasketItemDTO bb : bidtos) {
				new ChangeBstatus(bb.getBasketID(), bstatus);
			}
			
		}
		
	}
}
