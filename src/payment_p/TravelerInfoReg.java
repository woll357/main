package payment_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.TravelerInfoDAO;
import db_p.TravelerInfoDTO;
import di.MvcAction;
import di.MvcForward;

public class TravelerInfoReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("TravelerInfoReg들어와?");
		
		String [] basketIDs = request.getParameterValues("basketIDs"); //모두 H면 돌면 안돼.
		
		System.out.println("장바구니 몇개 갖고있어?"+basketIDs.length);
		
		boolean chk = false;
		
		AAA: for (int i = 0; i < basketIDs.length; i++) {
			System.out.println(i);
			BasketDTO dto = new BasketDTO();
			dto.setBasketID(basketIDs[i]);
			dto = new BasketDAO().detail(dto);
			
			
			if(dto.getcType().equals("A")) {
				System.out.println("여긴들어와?");
				chk = true;
				break AAA;
			}
		}
		if(chk) {
		
			
		System.out.println("비행기 고객 정보 입력 진입하니?");
			
		String [] airBaskets = request.getParameterValues("airBaskets");
		
		
		String pname = request.getParameterValues("cKorName")[0];
		String mainEngLastName = request.getParameterValues("cEngLastName")[0];
		String mainEngFirstName = request.getParameterValues("cEngFirstName")[0];
		
		String id = "1112";//((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		String bid = request.getParameter("bid");
		System.out.println(id);

		
		
		for (int i = 0; i < airBaskets.length; i++) {
			TravelerInfoDTO dto = new TravelerInfoDTO();
			
			System.out.println("비행기 장바구니"+airBaskets[i]);
			dto.setBasketID(airBaskets[i]);		
			
			for (int j = 0; j < request.getParameterValues("passport").length; j++) {	
				
				dto.setMainEngLastName(mainEngLastName);
				dto.setMainEngFirstName(mainEngFirstName);
				dto.setId(id);
				dto.setPname(pname);
				dto.setcKorName(request.getParameterValues("cKorName")[j]);
				dto.setPassport(request.getParameterValues("passport")[j]);
				dto.setcEngLastName(request.getParameterValues("cEngLastName")[j]);
				dto.setcEngFirstName(request.getParameterValues("cEngFirstName")[j]);
				dto.setBirthDate(request.getParameterValues("birthDate")[j]);
				dto.setCph(request.getParameterValues("cph1")[j]+request.getParameterValues("cph2")[j]+request.getParameterValues("cph3")[j]);
				dto.setCemail(request.getParameterValues("cemail1")[j]+"@"+request.getParameterValues("cemail2")[j]);
			
				new TravelerInfoDAO().insert(dto);
			};
		};
		
		int totalPrice = 0;
		
		for (int i = 0; i < basketIDs.length; i++) {
			BasketDTO dto = new BasketDTO();
			
			dto.setBasketID(basketIDs[i]);
		
			dto = new BasketDAO().detail(dto);
			System.out.println("얼마니?"+dto.getTotalPrice());
			totalPrice+=dto.getTotalPrice();
		}
		
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("basketIDs", basketIDs);
		request.setAttribute("mainUrl", "payment/PaymentMain.jsp");
		request.setAttribute("topUrl", "payment/PaymentMainTop.jsp");
		
		return null;
		}
		else if(!chk) {
			
			int totalPrice = 0;
			
			for (int i = 0; i < basketIDs.length; i++) {
				BasketDTO dto = new BasketDTO();
				
				dto.setBasketID(basketIDs[i]);
			
				dto = new BasketDAO().detail(dto);
				System.out.println("얼마니?"+dto.getTotalPrice());
				totalPrice+=dto.getTotalPrice();
			}
			
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("basketIDs", basketIDs);
			request.setAttribute("mainUrl", "payment/PaymentMain.jsp");
			request.setAttribute("topUrl", "payment/PaymentMainTop.jsp");
			
			return null;
		}
		return null;
	}
}
