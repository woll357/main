package basket_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;

public class BasketGo {
	public BasketGo(String id, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated constructor stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BasketDTO myDTO = new BasketDTO();
		
		myDTO.setId(id);

		ArrayList<BasketDTO> adtos = new ArrayList<BasketDTO>();
		ArrayList<BasketDTO> hdtos = new ArrayList<BasketDTO>();
		
		
		ArrayList<BasketDTO> myBasketList = new BasketDAO().itemCNT(myDTO);
		
		for (BasketDTO basket : myBasketList) {

			if(basket.getcType().equals("A")) {
				
				adtos.add(basket);
				
			}
			else if(basket.getcType().equals("H")) {
				hdtos.add(basket);
			}
			
		}
		
		request.setAttribute("adtos", adtos);
		request.setAttribute("hdtos", hdtos);
		
	}
}
