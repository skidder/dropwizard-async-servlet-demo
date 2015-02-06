package async.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Scott Kidder
 * 
 */
@WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    private static final long serialVersionUID = 555137137817785605L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        final AsyncContext ac = request.startAsync(request, response);
        ac.start(new Runnable() {
            public void run() {
                try {
                    final PrintWriter responseWriter = new PrintWriter(response.getOutputStream());
                    int i = 0;
                    while (i++ < 10) {
                        getServletContext().log(Integer.toString(i));
                        responseWriter.println(i);
                        responseWriter.flush();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ac.complete();
            }
        });
    }
}
