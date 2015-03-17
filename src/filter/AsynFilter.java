package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by huihui on 15-3-17.
 */
@WebFilter(filterName = "AsynFilter",asyncSupported = true,
        value = {"/AsynServlet"},
        dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.ASYNC})
public class AsynFilter implements Filter {
    @Override
    public void init(FilterConfig config) {

    }
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,
                         FilterChain chain) throws IOException,ServletException{
        System.out.println("start.....AsynFilter");
        chain.doFilter(request, response);
        System.out.println("end.....AsynFilter");
    }
    @Override
    public void destroy() {

    }
}
