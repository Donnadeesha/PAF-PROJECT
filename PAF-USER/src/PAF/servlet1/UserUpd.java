package PAF.servlet1;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paf.model.User1;

import PAF.service.UserDAO1;
/**
 * Servlet implementation class Userupdate
 */
@WebServlet("/Userupdate")
public class UserUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     *
    public Userupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		HttpSession session = request.getSession();
		
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String age = request.getParameter("age");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		User1 u = new User1();
		
		u.setfirst(first);
		u.setlast(last);
		u.setemail(email);
		u.setage(age);
		u.setmobile(mobile);
		u.setpassword(password);
		
		
	
		
		String sql = "update user set first=?,lname=?,age=?,mobile=?,password=? where email=?";  //Column names
		int us=UserDAO1.update(u,sql);
		
		
		
		if(us!= 0) {
			
			session.setAttribute("first", first);
			session.setAttribute("last", last);
			session.setAttribute("email", email);
			session.setAttribute("age", age);
			session.setAttribute("mobile", mobile);
			session.setAttribute("password", password);
			
			request.setAttribute("msg", "update sucessfuly");
			
			
			request.getRequestDispatcher("UpdateAccUser1.jsp").forward(request, response);
			//getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
			
			
		}
		
		else {
			request.getRequestDispatcher("UpdateAccUser1.jsp").forward(request, response);
	
			//request.setAttribute("msg", "update not sucessfuly");
			//request.getRequestDispatcher("").forward(request, response);
			//getServletContext().getRequestDispatcher("/").forward(request, response);
			
		}
	}

}
