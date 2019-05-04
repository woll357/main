package manager_p;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Air_itemDAO;
import di.MvcAction;
import di.MvcForward;

public class Airp_List2 implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int limit = 3; //한 페이지 당 게시물 수
	      
	      int pageLimit = 4 ; //리스트 하단에 보여질 페이지 번호 갯수
	      
	      
	      int page = 1;
	      if(request.getParameter("page")!=null) {
	         page = Integer.parseInt(request.getParameter("page")); //페이지가 널이 아니면 페이지를 받아오겠다.
	      }
	      Air_itemDAO dao = new Air_itemDAO();
	      int total = dao.total();
	      
	      //천체페이지수
	      int totalpage = total/limit;
	      
	      if(total%limit>0)
	    	  totalpage++;
	      
	      
	      int startpage = (page-1)/pageLimit*pageLimit+1;   //나머지를 걷어내기 위함
	      int endpage = startpage+pageLimit-1;
	      
	      if(endpage>totalpage)
	    	  endpage = totalpage;  // 넘는 페이지는 안나오게. 
	      
	      int start = (page-1)*limit;  //페이지 번호
		
		
	      
		
		
	      request.setAttribute("dto", dao.mair_pitemlist(request.getParameter("air_p") , start , limit));      
	     
	      
	      request.setAttribute("start", start);
	      request.setAttribute("nowpage", page);
	      request.setAttribute("startpage", startpage);
	      request.setAttribute("endpage", endpage);
	      request.setAttribute("totalpage", totalpage);
	      request.setAttribute("totalpage",totalpage);
	
		return null;
	}

}
