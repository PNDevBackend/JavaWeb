

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailList
 */
public class mailList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public mailList() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
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
            url="/baitap1.html";
        }
        else if(action.equals("add")) {
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String email=request.getParameter("email");
            String dateOfBirth=request.getParameter("dateOfBirth");
            User user=new User(firstName,lastName,email,dateOfBirth);
            request.setAttribute("user", user);
            url="/thanks.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
            System.out.println("User Email: " + user.getEmail());
            System.out.println("User FirstName: " + user.getFirstName());
            System.out.println("User LastName: " + user.getLastName());
            System.out.println("User DateOfBirth: " + user.getDateOfBirth());

        }

    }

}
