package payment_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;
import db_p.PaymentDAO;
import db_p.PaymentDTO;
import di.MvcAction;
import di.MvcForward;

public class PaymentReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
			
			String id = "1112";
			int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
			
			String [] basketIDs = request.getParameterValues("basketIDs");
			
			System.out.println("장바구니코드 나오니?11");			
			for (String string : basketIDs) {
				System.out.println("장바구니코드 나오니?"+string);
					
			}
			
			PaymentDTO dto = new PaymentDTO();
			dto.setcComName(request.getParameter("cComName"));
			String cNum = "";
			for (String cn : request.getParameterValues("cNum")) {
				cNum+=cn;
			};
			dto.setcNum(cNum);
			String exDate = "";
			for (String ed : request.getParameterValues("exDate")) {
				exDate+=ed;
			};
			dto.setExDate(exDate);
			dto.setcPw(request.getParameter("cPw"));
			dto.setCvc(request.getParameter("cvc"));
			dto.setId(id);//id
			new PaymentDAO().modify(dto);
			
			dto = new PaymentDAO().detail(dto);
			
			BuyDTO bdto = new BuyDTO();
			
			bdto.setBnum(basketIDs.length); //bnum
			Date now = new Date();
			bdto.setBdate(now);//현재시간
			bdto.setId(id);//내아이디
			bdto.setTotalPrice(totalPrice);;
			bdto.setpCode(""+dto.getpCode());
			
			
			new BuyDAO().insert(bdto); //구매테이블 만들었다.
			
			bdto = new BuyDAO().detail(bdto); //구매튜플의 구매코드 가지고오기
			
			
			
			for (int i = 0; i < basketIDs.length; i++) {
				
				BasketDTO badto = new BasketDTO();
				
				BasketpaidDTO bpdto = new BasketpaidDTO();
				
				System.out.println("나와라 얍얍!!"+basketIDs[i]);
				
				System.out.println(basketIDs[i]+"장바구니 코드는 나오니?");
				badto.setBasketID(basketIDs[i]);				
				bpdto.setBasketID(basketIDs[i]);
				
				badto = new BasketDAO().detail(badto);
				
				System.out.println(badto.getDdateStr()+"이거 널이니?");
				
				bpdto.setBasketID(badto.getBasketID());
				bpdto.setcType(badto.getcType());
				bpdto.setcNum(badto.getcNum());
				bpdto.setcName(badto.getcName());
				bpdto.setItemName(badto.getItemName());
				bpdto.setDdate(badto.getDdate());
				bpdto.setFdate(badto.getFdate());
				bpdto.setLocation1(badto.getLocation1());
				bpdto.setLocation2(badto.getLocation2());
				bpdto.setTotalPrice(badto.getTotalPrice());
				bpdto.setPsn(badto.getPsn());
				bpdto.setBcode(bdto.getBcode());
				bpdto.setId(badto.getId());
				
				new BasketpaidDAO().insert(bpdto); //구매된 장바구니에 넣는다.
				new BasketDAO().delete(badto);	//기존 장바구니에서 삭제한다.
				
				BasketItemDTO bidto = new BasketItemDTO();
				bidto.setBasketID(basketIDs[i]);
				bidto.setBstatus("m");
				new BasketItemDAO().modifyBstatus(bidto); //모든  상품코드의 상태를 예약상태로 바뀐다.
				
				
				
				//클래스로 빼기, 구매코드별 장바구니 항목 보기
				
				ArrayList<BasketpaidDTO> jbdtos = new ArrayList<BasketpaidDTO>(); //방금 산 장바구니 항목들 갖고온다.
				bpdto.setBcode(bdto.getBcode());
				
				
		

				jbdtos = new BasketpaidDAO().justBuyList(bpdto);
				ArrayList<BasketpaidDTO> adtos = new ArrayList<BasketpaidDTO>();
				ArrayList<BasketpaidDTO> hdtos = new ArrayList<BasketpaidDTO>();
				
				
				for (BasketpaidDTO justbuydto : jbdtos) {

					if(justbuydto.getcType().equals("A")) {
						
						adtos.add(justbuydto);
						
					}
					else if(justbuydto.getcType().equals("H")) {
						hdtos.add(justbuydto);
					}
					
				}
				
				
	
				
				request.setAttribute("bdto",bdto);
				request.setAttribute("hdtos",hdtos);
				request.setAttribute("adtos",adtos);
				request.setAttribute("mainUrl", "payment/JustBuyDetail.jsp");
				request.setAttribute("topUrl", "payment/JustBuyDetailTop.jsp");
				
				
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		

		return null;
	}

}
