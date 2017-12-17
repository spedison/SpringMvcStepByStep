package com.spedison.webSimpleTutorial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Mapp(name = "ErroIntratavel", urlPatterns = "/errointratavel.html")
public class ErroNaoTratado  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        if(1 == 1)
            throw new RuntimeException("Problema de execução, Forçar erro 500");

        super.doGet(httpServletRequest, httpServletResponse);
    }
}
