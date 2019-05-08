package payment_p;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import db_p.Air_itemDTO;
import db_p.BasketDAO;
import db_p.BasketDTO;
import db_p.BasketItemDAO;
import db_p.BasketItemDTO;
import db_p.BasketpaidDAO;
import db_p.BasketpaidDTO;
import db_p.BuyDAO;
import db_p.BuyDTO;
import db_p.Hold_tableDTO;
import db_p.Hot_tempDAO;
import db_p.PaymentDAO;
import db_p.PaymentDTO;
import db_p.Room_itemDTO;
import db_p.SignUpDTO;
import db_p.TravelerInfoDAO;
import db_p.TravelerInfoDTO;
import db_p.TravelerInfo_tempDAO;
import db_p.TravelerInfo_tempDTO;
import di.MvcAction;
import di.MvcForward;

public class PaymentReg implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			request.setCharacterEncoding("utf-8");

			String id = ((SignUpDTO) (request.getSession().getAttribute("mem"))).getId();

			String[] basketIDs = request.getParameterValues("basketIDs");
			String cComName = request.getParameter("cComName");

			// 결제정보 입력

			PaymentDTO dto = new PaymentDTO();

			String cNum1 = request.getParameter("cNum1");
			String cNum2 = request.getParameter("cNum2");
			String cNum3 = request.getParameter("cNum3");
			String cNum4 = request.getParameter("cNum4");
			String exDateMonth = request.getParameter("exDateMonth");
			String exDateYear = request.getParameter("exDateYear");

			String cPw = request.getParameter("pw");
			String cvc = request.getParameter("cvc");

			boolean[] chkBaskets = new boolean[basketIDs.length]; // 상품 존재 여부

			for (int i = 0; i < basketIDs.length; i++) {
				BasketDTO bdto = new BasketDTO();
				bdto.setBasketID(basketIDs[i]);
				bdto = new BasketDAO().detail(bdto);
				int psn = bdto.getPsn();

				if (bdto.getCode().substring(0, 1).equals("A")) {
					Air_itemDTO aidto = new Air_itemDTO();
					aidto.setCcode(bdto.getCode());
					try {
						aidto = new Air_itemDAO().detail(aidto);
						if (aidto.getSeatcnt() + psn > aidto.getTotseatcnt()) {
							chkBaskets[i] = false;
						} else {
							chkBaskets[i] = true;
						}
					} catch (Exception e) {
						chkBaskets[i] = false;//여기 확인할 것
						System.out.println("항공편이 삭제되서 존재하지 않는다.");
					}

				} // 항공 확인

				else if (bdto.getCode().substring(0, 1).equals("H")) {
					System.out.println("chk1111111111111111");
					Room_itemDTO ridto = new Room_itemDTO();
					ridto.setRcode(bdto.getCode());
					ridto = new Hot_tempDAO().roomDetailByrcode(ridto);
					int daynum = (int) ((bdto.getFdate().getTime() - bdto.getDdate().getTime()) / (1000 * 60 * 60 * 24))
							+ 1; // 몇박이니?
					
					System.out.println("호호호호홓ㄹ 몇박이니?"+daynum);
					
					boolean chk = true;
					AAA: for (int j = 0; j < daynum; j++) {
						System.out.println("chk22222222222222222");
						BasketItemDTO bidto = new BasketItemDTO();
						bidto.setDdate(bdto.getDdate());
						bidto.setRcode(bdto.getCode());
						int arn = new BasketItemDAO().countNumByDdateRcode(bidto); // 이미팔린 숫자

						
						Hold_tableDTO hdto = new Hold_tableDTO();
						hdto.setRcode(bdto.getCode());
						hdto.setNoresdate(bdto.getDdate());
						hdto = new Hot_tempDAO().detailHoldByDdateRcode(hdto);
						int rc = 0;
						try {
							rc = hdto.getNorescnt(); // 방 막힌 갯수.
						} catch (Exception e) {
							rc = 0;//값이 없다면
						}
						
						System.out.println("rc"+rc);
						System.out.println("arn"+arn);
						System.out.println("ridto.getRcnt"+ridto.getRcnt());
					
						if (rc + arn + 1 > ridto.getRcnt()) {
							System.out.println("들어와?들어오면안되는데?");
							chk = false;
							break AAA;
						}
						// 방의 갯수
						bidto.getDdate().setDate(bidto.getDdate().getDate() + 1);// 하루추가
						bidto.setDdate(bidto.getDdate());
					}
					
					if (!chk) {
						chkBaskets[i] = false;
						System.out.println("chk333333333333333333333333");
					} else {
						chkBaskets[i] = true;
						System.out.println("chk33qweqweqwe");
					}
				} // 호텔 확인
			} // 전체확인

			boolean cancel = false;
			for (int j = 0; j < chkBaskets.length; j++) {// 안되는거 지웠어
				if (!chkBaskets[j]) {
					System.out.println("chk444444444444444444444");
					BasketDTO bdto = new BasketDTO();
					BasketItemDTO basketItemDto = new BasketItemDTO();
					bdto.setBasketID(basketIDs[j]);
					bdto = new BasketDAO().detail(bdto);

					basketItemDto.setBasketID(basketIDs[j]);

					new BasketDAO().delete(bdto);
					new BasketItemDAO().delete(basketItemDto);
					cancel = true; // 삭제된적이 있다. 그러므로 구매가 진행되면 안된다.
					
				}
			}

			if (!cancel) { // 구매취소가 없을 경우 정상적으로 진행된다.
				for (int i = 0; i < basketIDs.length; i++) {
					System.out.println("chk555555555555555555555555555");
					System.out.println("===============================" + basketIDs[i]);
					
					
					BasketDTO tt = new BasketDTO();
					tt.setBasketID(basketIDs[i]);
					tt = new BasketDAO().detail(tt);
					
					System.out.println("하하하하하하 숫자 몇이냐?"+tt.getPsn());
					
					if(tt.getcType().equals("A")) { //항공편이면, seatcnt 업데이트 시켜주기
						System.out.println("");
						
						System.out.println("나나나나나나난나나ㅏ 숫자 몇이냐?"+tt.getPsn());
						
						Air_itemDTO aidto = new Air_itemDTO();
						aidto.setCcode(tt.getCode());
						aidto = new Air_itemDAO().detail(aidto);
						aidto.setSeatcnt(tt.getPsn());
						new Air_itemDAO().update_seatcnt(aidto);
						
						TravelerInfo_tempDTO ttdto = new TravelerInfo_tempDTO();
						ttdto.setBasketID(basketIDs[i]);
						ArrayList<TravelerInfo_tempDTO> ttdtos = new TravelerInfo_tempDAO().TravelerInfoListByBasketID(ttdto);
						
						for (TravelerInfo_tempDTO ttt : ttdtos) {
							TravelerInfoDTO tdto = new TravelerInfoDTO();
							
							tdto.setPassport(ttt.getPassport());
							tdto.setId(ttt.getId());
							tdto.setMainEngLastName(ttt.getMainEngLastName());
							tdto.setMainEngFirstName(ttt.getMainEngFirstName());
							tdto.setPname(ttt.getPname());
							tdto.setBirthDate(ttt.getBirthDate());
							tdto.setcEngLastName(ttt.getcEngLastName());
							tdto.setcEngFirstName(ttt.getcEngFirstName());
							tdto.setcKorName(ttt.getcKorName());
							tdto.setCph1(ttt.getCph1());
							tdto.setCph2(ttt.getCph2());
							tdto.setCph3(ttt.getCph3());
							tdto.setCemail1(ttt.getCemail1());
							tdto.setCemail2(ttt.getCemail2());
							tdto.setBasketID(ttt.getBasketID());
							
							new TravelerInfoDAO().insert(tdto);
							new TravelerInfo_tempDAO().delete(ttt);
						}
						
						
					}
					
					BuyDTO bdto = new BuyDTO();

					bdto.setBasketID(basketIDs[i]); // bnum
					Date now = new Date();
					bdto.setBdate(now);// 현재시간
					bdto.setId(id);// 내아이디
					bdto.setTotalPrice(tt.getTotalPrice());

					new BuyDAO().insert(bdto); // 구매테이블 만들었다.

					bdto = new BuyDAO().detail(bdto); // 구매튜플의 구매코드 가지고오기

					System.out.println(bdto.getBcode() + "bcode나와라!!!!!!!!!!!!");

					dto.setBcode(bdto.getBcode());
					dto.setcComName(cComName);
					dto.setcNum1(cNum1);
					dto.setcNum2(cNum2);
					dto.setcNum3(cNum3);
					dto.setcNum4(cNum4);
					dto.setExDateMonth(exDateMonth);
					dto.setExDateYear(exDateYear);
					dto.setcPw(cPw);
					dto.setCvc(cvc);
					dto.setId(id);

					new PaymentDAO().insert(dto);

					dto = new PaymentDAO().detail(dto);

					bdto.setpCode("" + dto.getpCode());
					bdto.setBdate(now);
					bdto.setId(id);

					new BuyDAO().givePcode(bdto);

					///////////////////// 장바구니 넘기기
					BasketDTO badto = new BasketDTO();
					BasketpaidDTO bpdto = new BasketpaidDTO();

					System.out.println(basketIDs[i] + "장바구니 코드는 나오니?");
					badto.setBasketID(basketIDs[i]);
					bpdto.setBasketID(basketIDs[i]);

					badto = new BasketDAO().detail(badto);

					System.out.println(badto.getDdateStr() + "이거 널이니?");

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
					bpdto.setCode(badto.getCode());
					

					new BasketpaidDAO().insert(bpdto); // 구매된 장바구니에 넣는다.
					new BasketDAO().delete(badto); // 기존 장바구니에서 삭제한다.

					BasketItemDTO bidto = new BasketItemDTO();
					bidto.setBasketID(basketIDs[i]);
					bidto.setBstatus("m");
					new BasketItemDAO().modifyBstatus(bidto); // 모든 상품코드의 상태를 예약상태로 바뀐다.

				}

				// 클래스로 빼기, 구매코드별 장바구니 항목 보기

				ArrayList<BasketpaidDTO> adtos = new ArrayList<BasketpaidDTO>();
				ArrayList<BasketpaidDTO> hdtos = new ArrayList<BasketpaidDTO>();

				int totalPrice = 0;

				for (int j = 0; j < basketIDs.length; j++) {
					BasketpaidDTO jbdto = new BasketpaidDTO();
					jbdto.setBasketID(basketIDs[j]);
					jbdto = new BasketpaidDAO().detail(jbdto);

					if (jbdto.getcType().equals("A")) {
						adtos.add(jbdto);
						for (int k = 0; k < jbdto.getPsn(); k++) {
							totalPrice += jbdto.getTotalPrice();
						}
						
					} else if (jbdto.getcType().equals("H")) {
						hdtos.add(jbdto);
						totalPrice += jbdto.getTotalPrice();
					}
				}
				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("hdtos", hdtos);
				request.setAttribute("adtos", adtos);

				request.getSession().setAttribute("basketIDs", basketIDs);
				request.setAttribute("msg", "결제 완료되었습니다.");
				request.setAttribute("goUrl", "JustBuyDetail");
				request.setAttribute("mainUrl", "payment/alert.jsp");
			} else if (cancel) { // 구매취소가 있을 경우
				request.setAttribute("msg", "구매 불가능한 상품이 존재합니다.");
				request.setAttribute("goUrl", "../Basket/BasketMain");
				request.setAttribute("mainUrl", "payment/alert.jsp"); //테스트해봐야한다.
			}
		}

		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
