package basket_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_comDAO;
import db_p.Air_comDTO;
import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class BasketAirReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String [] cCodes = request.getParameterValues("ccode"); //넘겨받는게 ccode로 들어오고 나는 cCodes로 넣는다.

		for (String string : cCodes) {
			System.out.println(string);
		}
		
		
		String id = ((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		String cType = cCodes[0].substring(0, 1);
		
		System.out.println(cType);
	

		if(cType.equals("A")) {
			
			int psn= Integer.parseInt(request.getParameter("seatcnt")); // 좌석수로 받고 psn으로 넣는다.
			System.out.println(psn);
			
			System.out.println("씨코드갯수"+cCodes.length); //1 또는 2
			
			for (int i = 0; i < cCodes.length; i++) { 
				System.out.println("두번놔아라!");
				
				Air_itemDTO airdto = new Air_itemDTO();
				airdto.setCcode(cCodes[i]);
				
				airdto = new Air_itemDAO().itemdetail(airdto); //편도정보를 가지고온다.
				

				Air_comDTO aircomdto = new Air_comDTO();
				aircomdto.setAir_code(airdto.getAir_code());//항공편 정보에서 가지고온 항공사 코드를 항공사 dto에 세팅
				
				aircomdto = new Air_comDAO().serarchByAirCode(aircomdto);//항공사 정보 찾기

				System.out.println(airdto);
				System.out.println(cCodes[i]);
				
				BasketDTO dto = new BasketDTO();
				dto.setId(id);
				dto.setPsn(psn);
				dto.setcNum(1);
				dto.setcType(cType);
				
				dto.setcName(aircomdto.getAir_name());
				
				dto.setItemName(airdto.getAp_code());
				dto.setLocation1(airdto.getDarea());
				dto.setLocation2(airdto.getCarea());

				int no = new BasketDAO().itemCNT(dto).size();
				dto.setNo(no);
				System.out.println(no); //나 장바구니에 몇개있니?

				dto.setDdate(airdto.getDdate());
				dto.setFdate(airdto.getA_time());
				dto.setTotalPrice(airdto.getMoney());
				
				System.out.println(airdto.getA_time());
				
				
				new BasketDAO().insert(dto);
				
				System.out.println("삽입까지 성공했다");
				
				dto = new BasketDAO().findBasketID(dto);
				
				BasketItemDTO itemdto = new BasketItemDTO();
				
				System.out.println("basketID뭐야?"+dto.getBasketID());
				
				itemdto.setBasketID(dto.getBasketID());
				
				
				itemdto.setcCode(cCodes[i]);		//상품코드
				itemdto.setPrice(airdto.getMoney());//가격
				itemdto.setRcode(cCodes[i]);		//빈값 주기 싫어서 그냥 중복
				itemdto.setDdate(airdto.getDdate());
				
				
				new BasketItemDAO().insert(itemdto);				
				//넣어준 basketID를 찾아야한다 자신의 id와 no로.
				//지울 때 지운 no보다 큰 장바구니 item의 no는 1씩 감소
				
				System.out.println("===================================");
			}
			
		}

		new BasketGo(id, request, response);
		
		//장바구니에 보여줄 내용
		//항공사명- 비행기코드, 출발날짜, 도착날짜, 출발도시, 도착도시, 예약인원, 총액,
		//
		//호텔 이름- 방종류, 체크인날짜, 체크아웃날짜, 국가, 도시, 방인원, 총액,
	
		return null;
	}

}
