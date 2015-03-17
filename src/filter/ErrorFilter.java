package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by huihui on 15-3-17.
 */
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig config) {

    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                         FilterChain chain) throws IOException,ServletException{
        System.out.println("页面不存在");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }


}
