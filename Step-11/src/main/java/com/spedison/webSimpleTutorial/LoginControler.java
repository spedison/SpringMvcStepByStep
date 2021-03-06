package com.spedison.webSimpleTutorial;


import com.spedison.helper.SpringHttpHelper;
import com.spedison.service.ValidationPassword;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/*
 * Browser sends Http Request to Web Server
 *
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 *
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class
//used to extend the capabilities of servers
//that host applications accessed by means of
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

//@WebServlet(urlPatterns = "/login.html", loadOnStartup = 1)
@Controller
@RequestMapping(value = "/")
@SessionScope
public class LoginControler {

    private long errorCounter = 0;
    private ValidationPassword validationPassword = new ValidationPassword();

    @RequestMapping(value = "test.html")
    @ResponseBody
    public String hello(){
        return "Alô povo da Web, eu cheguei !!!";
    }

    @RequestMapping(value = "login.html", method = RequestMethod.GET)
    public String preLogin(){
        return "login";
    }

    @RequestMapping(value = "login.html", method = RequestMethod.POST)
    public ModelAndView postLogin(String name, String password){
        ModelAndView model;
        ValidationPassword vp = new ValidationPassword();

        boolean retOk = vp.isValidPassword(name, password);

        if(retOk) {
            model = new ModelAndView("welcome");
            model.addObject("name", name);
            model.addObject("session", SpringHttpHelper.session().getId());
            errorCounter = 0;
        } else {
            errorCounter++;
            model = new ModelAndView("login");
            model.addObject("name", name);
            model.addObject("message", "Problemas na autenticação. Você errou " + errorCounter + " vez(es)");
            model.addObject("session", SpringHttpHelper.session().getId());
        }

        return model;
    }

    public LoginControler(){
        System.out.println("Iniciado ...");
    }
}
