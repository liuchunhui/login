package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by huihui on 15-3-16.
 */
public class SecondFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException{
        System.out.println("init----SecondFilter");
    }
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                         FilterChain chain) throws IOException,ServletException{
        System.out.println("start----doFilter----SecondFilter");
        chain.doFilter(request,response);
        System.out.println("end----doFilter----SecondFilter");
    }
    @Override
    public void destroy() {
        System.out.println("destroy----SecondFilter");
    }
}
