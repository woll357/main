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

public class FnqList implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int page = 1;
	      
	      int limit = 10; //한 페이지 당 게시물 수
	      
	      int pageLimit = 4 ; //리스트 하단에 보여질 페이지 번호 갯수
	      
	      if(request.getParameter("page")!=null) {
	         page = Integer.parseInt(request.getParameter("page")); //페이지가 널이 아니면 페이지를 받아오겠다.
	      }
		
		
	      CenterDAO dao = new CenterDAO();
	      //전체글 수 가져오기.
	      int total = dao.total("fnq");
	      
	      //천체페이지수
	      int totalPage = total/limit;
	      
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
	      request.setAttribute("data",dao.fnqList(start, limit)); 
	      request.setAttribute("totcnt", total);
		
		
		
		return null;
	}

}
