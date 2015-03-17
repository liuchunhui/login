package login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by huihui on 15-3-17.
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)
    throws IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);

        if ("admin".equals(username) && "admin".equals(password)) {
            // 校验通过
            HttpSession session = request.getSession();
            session.setAttribute("username",username);

            System.out.println(request.getContextPath());
            response.sendRedirect(request.getContextPath() + "/success.jsp");


        }else {
            // 校验失败
            response.sendRedirect(request.getContextPath() + "/fail.jsp");
        }

    }
}
