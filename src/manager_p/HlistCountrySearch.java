package manager_p;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db_p.Hot_comDTO;
import db_p.Hot_tempDAO;
import di.MvcAction;
import di.MvcForward;

public class HlistCountrySearch implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Hot_comDTO dto = new Hot_comDTO();
		dto.setCountry(request.getParameter("country"));
		
		int limit = 3;   //한 페이지 당 게시물 수
		int pageLimit = 5; //리스트 하단에 보여질 페이지 갯수
		
		
		int page = 1;
		if(request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Hot_tempDAO dao = new Hot_tempDAO();
		
		//전체 글 수 가져오기		
		int total = dao.total2(dto);
		
		//전체 페이지수
		int totalPage = total/limit;
		if(total%limit>0) 
		{
			totalPage++;
		}
		
		int startPage = (page-1)/pageLimit*pageLimit+1;
		int endPage = startPage+pageLimit-1;
		
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		
		int start = (page-1)*limit;
		
		

		
		request.setAttribute("data", new Hot_tempDAO().countrysearch(dto,start,limit));

		request.setAttribute("start",start);
		request.setAttribute("nowPage",page);
		request.setAttribute("startPage",startPage);
		request.setAttribute("endPage",endPage);
		request.setAttribute("totalPage",totalPage);
		

		System.out.println("방검색!"+dto.getCountry());
		
		return null;
	}

}
