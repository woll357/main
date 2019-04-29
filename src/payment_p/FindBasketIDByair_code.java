package payment_p;

import java.util.ArrayList;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;

public class FindBasketIDByair_code {
	
	public FindBasketIDByair_code(String air_code) {
		// TODO Auto-generated constructor stub
		
		Air_itemDTO aidto = new Air_itemDTO();
		aidto.setAir_code(air_code);
		ArrayList<Air_itemDTO> aidtos = new Air_itemDAO().itemlistByAir_Code(aidto);
		String bstatus= "r";
		
		for (Air_itemDTO aa : aidtos) {
			BasketItemDTO bidto = new BasketItemDTO();
			bidto.setRcode(aa.getCcode());
			ArrayList<BasketItemDTO> bidtos = new BasketItemDAO().basketIDListByRcode(bidto);
			
			for (BasketItemDTO bb : bidtos) {
				new ChangeBstatus(bb.getBasketID(), bstatus);
			}
			
		
			
		}
		
	}
}
