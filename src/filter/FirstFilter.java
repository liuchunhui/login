package filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by huihui on 15-3-16.
 */
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("first-----init");
    }
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                        FilterChain chain) throws IOException,ServletException{
        System.out.println("first----start----doFilter");

        chain.doFilter(request,response);

        System.out.println("second----end----doFilter");
    }
    @Override
    public void destroy() {
        System.out.println("second----destroy");
    }


}
