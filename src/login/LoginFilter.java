package login;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by huihui on 15-3-17.
 */
public class LoginFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig config) {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                         FilterChain chain) throws IOException,ServletException{
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;

        HttpSession session = httpServletRequest.getSession();

        String noLoginPaths = config.getInitParameter("noLoginPaths");

        String charset = config.getInitParameter("charset");

        if (charset == null) {
            charset = "UTF-8";
        }

        request.setCharacterEncoding(charset);

        if (noLoginPaths != null ) {
            String[] strArray = noLoginPaths.split(";");
            for (int i = 0; i < strArray.length; i++) {

                if (strArray[i] == null || "".equals(strArray[i]))
                      continue;
                if (httpServletRequest.getRequestURI().indexOf(strArray[i]) != -1) {
                    chain.doFilter(request,response);
                    return;
                }

            }
        }


        if (session.getAttribute("username") != null) {
            chain.doFilter(request,response);
        }else {
            httpServletResponse.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
