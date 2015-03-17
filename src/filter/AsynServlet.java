package filter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by huihui on 15-3-17.
 */
public class AsynServlet extends HttpServlet {


    public AsynServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) {

        System.out.println("Servlet执行开始时间" + new Date());

        // 启用异步
        AsyncContext context = request.startAsync();
        new Thread(new Excutor(context)).start();

        System.out.println("Servlet执行结束时间" + new Date());

    }

    public class Excutor implements Runnable {

        AsyncContext asyncContext;

        public Excutor(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {

            try {
                // 执行相关的复杂业务
                Thread.sleep(1000 * 10);
                asyncContext.getRequest();
                asyncContext.getResponse();
                System.out.println("业务执行完成时间" + new Date());
            }catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.print(this.getClass());
        out.println(", using the POST method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    public void init() throws ServletException {

    }

}
