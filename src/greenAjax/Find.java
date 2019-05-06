package greenAjax;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			
			if(request.getParameter("black")==null) {
			if(request.getParameter("id")!=null) {
				dto.setId(request.getParameter("id"));
				if(new SignUpDAO().chkMem(dto)) {
					request.setAttribute("data", new SignUpDAO().memList(dto));
					
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("msg", "No");
				}		
			}else if(request.getParameter("phone")!=null) {
				dto.setPhone(request.getParameter("phone"));
				if(new SignUpDAO().chkMem(dto)) {
					request.setAttribute("data", new SignUpDAO().memList(dto));
				
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("msg", "No");
				}		
			}else if(request.getParameter("pname")!=null) {
				dto.setPname(request.getParameter("pname"));
				if(new SignUpDAO().chkMem(dto)) {
					request.setAttribute("data", new SignUpDAO().memList(dto));
				
				}else if(!new SignUpDAO().chkMem(dto)){
					request.setAttribute("msg", "No");
				}		
			}
			}else {
				dto.setBlack(request.getParameter("black"));
				
				if(request.getParameter("id")!=null) {
					dto.setId(request.getParameter("id"));
					if(new SignUpDAO().chkMem(dto)) {
						request.setAttribute("data", new SignUpDAO().memList(dto));
						
					}else if(!new SignUpDAO().chkMem(dto)){
						request.setAttribute("msg", "No");
					}else if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}		
				}else if(request.getParameter("phone")!=null) {
					dto.setPhone(request.getParameter("phone"));
					System.out.println("여기");
					if(new SignUpDAO().chkMem(dto)) {
						request.setAttribute("data", new SignUpDAO().memList(dto));
					
					}else if(!new SignUpDAO().chkMem(dto)){
						request.setAttribute("msg", "No");
					}else if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}		
				}else if(request.getParameter("pname")!=null) {
					dto.setPname(request.getParameter("pname"));
					if(new SignUpDAO().chkMem(dto)) {
						request.setAttribute("data", new SignUpDAO().memList(dto));
					
					}else if(!new SignUpDAO().chkMem(dto)){
						request.setAttribute("msg", "No");
					}else if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}
				}else if(request.getParameter("preason")!=null) {
					
					dto.setPreason(request.getParameter("preason"));
					request.setAttribute("data", new SignUpDAO().memList(dto));
					
					if(((ArrayList<SignUpDTO>)new SignUpDAO().memList(dto)).size()==0){
						request.setAttribute("msg", "No");
					}		
				}
			}
			

		
		return null;
	}

}
