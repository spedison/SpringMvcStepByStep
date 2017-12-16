package erros;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Erro404Servlet.do", loadOnStartup = 1)
public class Erro404Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException
    {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");

        req.setAttribute("errorType", throwable);
        req.setAttribute("statusCode", statusCode);

        //colocando o setStatus OK
        res.setStatus(HttpServletResponse.SC_OK);

        // We have to remove the exception from the request. If we do not remove the IE9 will not display out error page.
        // IE9 will think that some error created a crash inside our application if we do not remove the exception from the request.
        req.setAttribute("javax.servlet.error.exception", null);
        req.setAttribute("javax.servlet.error.status_code", null);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/resources/views/erro404.jsp");
        requestDispatcher.forward(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException
    {
        doPost(req, res);
    }
}
