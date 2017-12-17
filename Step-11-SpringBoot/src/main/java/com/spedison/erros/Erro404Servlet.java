package com.spedison.erros;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/Erro404Servlet.do", loadOnStartup = 1)
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class Erro404Servlet extends RuntimeException  {

        private static final long serialVersionUID = 1L;

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)
            throws Exception {

        System.out.println("Executando o NotFound!!!");

        return new ModelAndView("erro404");
    }

/*
    public void doPost(HttpServletRequest req, HttpServletResponse res)    throws ServletException, IOException
    {
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");

        req.setAttribute("errorType", throwable);
        req.setAttribute("statusCode", statusCode);

        System.out.print("IP da Máquina: " + req.getLocalAddr() + " - " + req.getRemoteHost() + " - User : " + req.getRemoteUser()  + " - " + req.getAttribute("javax.servlet.error.request_uri"));

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
    */
}
