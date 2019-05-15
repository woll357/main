package nh_service_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.CenterDAO;
import db_p.CenterDTO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class QnaList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 int page = 1;
	      
	      int limit = 10; //한 페이지 당 게시물 수
	      
	      int pageLimit = 4 ; //리스트 하단에 보여질 페이지 번호 갯수
	      
	      if(request.getParameter("page")!=null) {
	         page = Integer.parseInt(request.getParameter("page")); //페이지가 널이 아니면 페이지를 받아오겠다.
	      }
	      
		HttpSession session = request.getSession();		
		CenterDTO dto = new CenterDTO();
		dto.setId(((SignUpDTO) session.getAttribute("mem")).getId());
		dto.setGrade(((SignUpDTO) session.getAttribute("mem")).getGrade());
		
		
		CenterDAO dao = new CenterDAO();
	      //전체글 수 가져오기.
	      int total = dao.total("qna");
	      ArrayList<Integer> cc = dao.qnaCnt(dto);
	      //천체페이지수
	      int totalPage=0;
	      if(dto.getGrade().equals("M")) {
	    	  totalPage = total/limit; // 21/3 = 7
	      }else {
	    	  totalPage = cc.get(0)/limit;
	      }
	      if(total%limit>0)
	         totalPage=totalPage+1;
	      
	      
	      int startPage = (page-1)/pageLimit*pageLimit+1;
	      int endPage = startPage+pageLimit-1;
	      
	      if(endPage>totalPage) {
	    	  endPage=totalPage;
	      }
	      
	      int start = (page-1)*limit;
	      
	      request.setAttribute("start", start);
	      request.setAttribute("nowPage", page);
	      request.setAttribute("startPage", startPage);
	      request.setAttribute("endPage", endPage);
	      request.setAttribute("totalpage", totalPage);
	      request.setAttribute("totalPage",totalPage);     
	      request.setAttribute("data",dao.qnaList(dto, start, limit)); 
	      request.setAttribute("totcnt", total);
	      request.setAttribute("mycnt", cc.get(0));
	      request.setAttribute("aacnt", cc.get(1)/2);
	      request.setAttribute("qqcnt", cc.get(2));
		
		
		
		return null;
	}

}
