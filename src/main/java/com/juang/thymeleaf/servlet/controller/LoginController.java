/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juang.thymeleaf.servlet.controller;

import com.juang.thymeleaf.servlet.config.TemplateEngineUtil;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author juang
 */
@WebServlet(urlPatterns = {"/login"}, initParams = {
    @WebInitParam(name = "status", value = "0", description = "nilai saat pertama load login")})
public class LoginController extends HttpServlet {
    
    private String status;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        status = config.getInitParameter("status");
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        context.setVariable("recipient", "World");
        
        if (this.status.equalsIgnoreCase("0")) {
            engine.process("login.html", context, response.getWriter());
        } else {
            engine.process("index.html", context, response.getWriter());
        }
    }
}
