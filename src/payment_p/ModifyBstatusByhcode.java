package payment_p;

import java.util.ArrayList;

import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;

public class ModifyBstatusByhcode {

	public ModifyBstatusByhcode(String hcode) {
		// TODO Auto-generated constructor stub
		System.out.println("실행되니?111111111111111111111111111111111111111111");
		Room_itemDTO ridto = new Room_itemDTO();
		ridto.setHcode(hcode);
		
		ArrayList<Room_itemDTO> ridtos = (ArrayList<Room_itemDTO>) new Hot_tempDAO().roomlist(ridto);
		
		System.out.println("Room_itemDTO size"+ridtos.size());

		for (Room_itemDTO rr : ridtos) {
			String bstatus= "m";
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(rr.getRcode());
			bidto.setBstatus(bstatus);
			System.out.println("rr.getRcode():"+rr.getRcode());
			
			
			ArrayList<BasketItemDTO> bidtos = new BasketItemDAO().basketIDListByRcode(bidto);
			
			for (BasketItemDTO bb : bidtos) {
				bstatus = "r";
				System.out.println("bb.getBasketID:"+bb.getBasketID());
				new ChangeBstatus(bb.getBasketID(), bstatus);
			}
			
		}
		
	}
}
