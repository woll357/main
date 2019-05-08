package basket_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;
import di.MvcAction;
import di.MvcForward;


public class BasketReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String [] basketIDs = request.getParameterValues("basketIDs");
		
		
		ArrayList<BasketDTO> airBaskets = new ArrayList<BasketDTO>();
		
		for (int i = 0; i < basketIDs.length; i++) {
			BasketDTO dto = new BasketDTO();
			System.out.println("basketIDs?"+basketIDs[i]);
			
			
			dto.setBasketID(basketIDs[i]);
			dto = new BasketDAO().detail(dto);
			
			
			if(dto.getcType().equals("A")) {
				airBaskets.add(dto);
			}

		}
		request.setAttribute("airBaskets", airBaskets);
		request.setAttribute("basketIDs", basketIDs);
		request.setAttribute("mainUrl", "payment/TravelerInfoMain.jsp");
		
		return null;
	}

}
