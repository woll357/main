package greenAjax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db_p.CenterDAO;
import db_p.SignUpDAO;
import db_p.SignUpDTO;
import di.MvcAction;
import di.MvcForward;

public class Find implements MvcAction {

	@Override
	public MvcForward execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	
			SignUpDTO dto = new SignUpDTO();
			
			HttpSession session = request.getSession();
			request.setAttribute("msg", "나오거든요?");
			
			
			if(request.getParameter("black")==null) {
			if(request.getParameter("id")!=null && request.getParameter("id")!="") {
				dto.setId(request.getParameter("id"));
				if(new SignUpDAO().chkMem(dto)) {
					request.setAttribute("data", new SignUpDAO().memList(dto));
					
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("msg", "No");
				}		
			}else if(request.getParameter("phone")!=null && request.getParameter("phone")!="") {
				dto.setPhone(request.getParameter("phone"));
				if(new SignUpDAO().chkMem(dto)) {
					request.setAttribute("data", new SignUpDAO().memList(dto));
					
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("msg", "No");
				}		
			}else if(request.getParameter("pname")!=null && request.getParameter("pname")!="") {
				dto.setPname(request.getParameter("pname"));
				if(new SignUpDAO().chkMem(dto)) {
					request.setAttribute("data", new SignUpDAO().memList(dto));
					
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("msg", "No");
				}		
			}
			}else {
				dto.setBlack(request.getParameter("black"));
				if(request.getParameter("id")!=null && request.getParameter("id")!="") {
					dto.setId(request.getParameter("id"));
					if(new SignUpDAO().chkMem(dto)) {
						request.setAttribute("data", new SignUpDAO().memList(dto));
						
					}else if(!new SignUpDAO().chkMem(dto)){
						request.setAttribute("msg", "No");
					}else if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
						
					}		
				}else if(request.getParameter("phone")!=null && request.getParameter("phone")!="") {
					dto.setPhone(request.getParameter("phone"));
					
					if(new SignUpDAO().chkMem(dto)) {
						request.setAttribute("data", new SignUpDAO().memList(dto));
						
					
					}else if(!new SignUpDAO().chkMem(dto)){
						request.setAttribute("msg", "No");
					}else if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}		
				}else if(request.getParameter("pname")!=null && request.getParameter("pname")!="") {
					dto.setPname(request.getParameter("pname"));
					if(new SignUpDAO().chkMem(dto)) {
						request.setAttribute("data", new SignUpDAO().memList(dto));
						
					
					}else if(!new SignUpDAO().chkMem(dto)){
						request.setAttribute("msg", "No");
					}else if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}
				}else if(request.getParameter("preason")!=null && request.getParameter("preason")!="") {
					
					dto.setPreason(request.getParameter("preason"));
					
					request.setAttribute("rr", "rr");
					
					
					 int page = 1;
				      
				      int limit = 5; //한 페이지 당 게시물 수
				      
				      int pageLimit = 4 ; //리스트 하단에 보여질 페이지 번호 갯수
				      
				      if(request.getParameter("page")!=null) {
				         page = Integer.parseInt(request.getParameter("page")); //페이지가 널이 아니면 페이지를 받아오겠다.
				      }
				      
				      CenterDAO dao = new CenterDAO();
				      
				      
				      
				      int total = dao.bbtotal(dto);
				      
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
				      request.setAttribute("data", new SignUpDAO().memList(dto,start, limit));
				      request.setAttribute("pprr", request.getParameter("preason"));

					if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}		
				}
			}
			

		
		return null;
	}

}
