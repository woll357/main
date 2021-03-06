package payment_p;

import java.util.ArrayList;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;

public class ModifyBstatusByAir_code {
	
	public ModifyBstatusByAir_code(String air_code) {
		// TODO Auto-generated constructor stub
		
		Air_itemDTO aidto = new Air_itemDTO();
		aidto.setAir_code(air_code);
		ArrayList<Air_itemDTO> aidtos = new Air_itemDAO().itemlistByAir_Code(aidto);
		
		for (Air_itemDTO aa : aidtos) {
			String bstatus= "m";
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(aa.getCcode());
			bidto.setBstatus(bstatus);
			
			ArrayList<BasketItemDTO> bidtos = new BasketItemDAO().basketIDListByRcode(bidto);
			for (BasketItemDTO bb : bidtos) {
				bstatus = "r";
				new ChangeBstatus(bb.getBasketID(), bstatus);
			}
			
		
			
		}
		
	}
}
