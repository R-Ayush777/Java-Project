package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

//import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@SuppressWarnings("serial")
@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // String uname = (String) request.getAttribute("uname");
        // String pass = (String) request.getAttribute("pass");
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
//		System.out.println("uname: " + uname);
//		System.out.println("pass: " + pass);

        LoginDao dao = new LoginDao();
        int res = dao.check(uname, pass);
        if (res == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("username", uname);
//			System.out.println("True");
            response.sendRedirect("home.jsp");
        } else if (res == 2) {
//			System.out.println("False");
            response.sendRedirect("uhome.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }

    }
}
