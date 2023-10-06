

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailList
 */
public class EmailList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
		String url="/index.html";
        String action=request.getParameter("action");
        if(action==null) {
            action="join";
        }
        if(action.equals("join")) {
            url="/5.1.html";
        }
        else if(action.equals("add")) {
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String email=request.getParameter("email");
            User user=new User(firstName,lastName,email);
            request.setAttribute("user", user);
            url="/5.1thanks.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
            System.out.println("User Email: " + user.getEmail());
            System.out.println("User FirstName: " + user.getFirstName());
            System.out.println("User LastName: " + user.getLastName());

        }
		doGet(request, response);
	}

}
