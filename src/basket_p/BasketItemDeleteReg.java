package basket_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class BasketItemDeleteReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = ((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		String basketID = request.getParameter("basketID");
		
		BasketDTO dto = new BasketDTO();
		BasketItemDTO basketItemDto = new BasketItemDTO();
		
		dto.setBasketID(basketID);
		
		dto = new BasketDAO().detail(dto);
		
		basketItemDto.setBasketID(basketID);
		
		if(new BasketDAO().delete(dto)) {
			new BasketItemDAO().delete(basketItemDto);
		}
		
		new BasketGo(id, request, response);
		return null;
	}

}
