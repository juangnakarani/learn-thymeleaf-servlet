/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juang.thymeleaf.servlet.controller;

import com.juang.thymeleaf.servlet.config.TemplateEngineUtil;
import java.io.IOException;
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
@WebServlet("/")
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());
        response.setContentType("charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        context.setVariable("recipient", "World");
        context.setVariable("boneng", "Iki boneng");
        System.out.println("menu: " + request.getServletContext().getAttribute("opo"));
        System.out.println("attr: " + request.getServletContext().getAttribute("attr"));
        context.setVariable("menu", request.getServletContext().getAttribute("opo"));
        engine.process("index", context, response.getWriter());
    }
}
