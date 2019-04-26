package basket_p;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;
import di.MvcForward;

public class BasketHotelReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String rcode = request.getParameter("rcode");
		
		String id = "1112";//((SignUpDTO)(request.getSession().getAttribute("mem"))).getId();
		
		String cType = rcode.substring(0, 1);
		System.out.println(cType);
		
		//
		Hot_comDTO hdto = new Hot_comDTO();
		Room_itemDTO rdto = new Room_itemDTO();
		rdto.setRcode(rcode);
		
		rdto = new Hot_tempDAO().roomDetailByrcode(rdto);
		hdto.setHcode(rdto.getHcode());
		
		hdto = new Hot_tempDAO().hotelDetailByhcode(hdto);
		

		//  총액, 
		BasketDTO dto = new BasketDTO();
		
		dto.setcType(cType);//상품종류
		dto.setId(id);//아이디
		dto.setcName(hdto.getHname());//회사명
		dto.setLocation1(hdto.getCountry());//위치값1
		dto.setLocation2(hdto.getCity());//위치값2
		dto.setItemName(rdto.getRkind()); //방종류
		dto.setPsn(rdto.getPcnt()); //인원수
		
		
		int no = new BasketDAO().itemCNT(dto).size();
		dto.setNo(no); //몇번째 장바구니 항목,
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int dateCNT = 0;
		
		try {
			Date startDay = sdf.parse(request.getParameter("startDay"));
			
			Date endDay = sdf.parse(request.getParameter("endDay"));
			dateCNT =  (int)(endDay.getTime()-startDay.getTime())/(1000*60*60*24);
			
					
			dto.setcNum(dateCNT);//상품코드 갯수
			
			startDay.setHours(17);
			endDay.setHours(12);
			dto.setDdate(startDay);//시작날짜
			dto.setFdate(endDay);// 끝날짜
			
			new BasketDAO().insert(dto);
			
			dto = new BasketDAO().findBasketID(dto);
			System.out.println("여기이인가?"+dto.getBasketID());
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			int totalPrice = 0;
			
			for (int i = 0; i < dateCNT; i++) {
				BasketItemDTO itemdto = new BasketItemDTO();
				itemdto.setBasketID(dto.getBasketID());
				itemdto.setRcode(rcode);
				
				int price = 0;

				itemdto.setDdate(startDay);
				
				if(startDay.getDay()==5 || startDay.getDay()==6) {
					price =rdto.getWmoney();
					totalPrice+=price;
				}
				else if(startDay.getDay()==0 || startDay.getDay()==1 || startDay.getDay()==2 || 
						startDay.getDay()==3 || startDay.getDay()==4 || startDay.getDay()==5) {
					price =rdto.getMoney();
					totalPrice+=price;
				}
				
				itemdto.setcCode(rcode+sdf2.format(startDay));//상품코드
				itemdto.setPrice(price);//가격
				
				new BasketItemDAO().insert(itemdto);
				startDay.setDate(startDay.getDate()+1);
			}
			
			System.out.println("총액"+totalPrice);
			dto.setTotalPrice(totalPrice);
			new BasketDAO().modifyTotalPrice(dto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		new BasketGo(id, request, response);
		
		//BasketID 의 초기값이 97이 나오는 이유를 알아야한다.
		
		//장바구니에 보여줄 내용
		//항공사명- 비행기코드, 출발날짜, 도착날짜, 출발도시, 도착도시, 예약인원, 총액,
		//
		//호텔 이름- 방종류, 체크인날짜, 체크아웃날짜, 국가, 도시, 방인원, 총액,
	
		return null;
	}
	
}
