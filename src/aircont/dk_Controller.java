package aircont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import di.MvcAction;
import di.MvcForward;

/**
 * Servlet implementation class dk_Controller
 */
@WebServlet("/airgreen/*")
public class dk_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dk_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		
		String service = request.getRequestURI().substring("/mainProj/airgreen/".length());
		
		System.out.println(service);
		
		/* request.setAttribute("TopUrl", "air/inc/top.jsp" ); */
		
		request.setAttribute("mainUrl", "air/"+service+".jsp" );
		
		/*
		 * request.setAttribute("HomeUrl", "air/"+service+"top"+".jsp" );
		 * request.setAttribute("MenuUrl", "air/inc/menu.jsp" );
		 */
		
		
		
		try {
			MvcAction action = (MvcAction)Class.forName("dk_service_p."+service).newInstance();
			MvcForward fowrard = action.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/template.jsp");
			
			dispatcher.forward(request, response);
			
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
