/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juang.thymeleaf.servlet.config;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author juang
 */
@WebListener
public class TemplateEngineUtil {

//    private static final String TEMPLATE_ENGINE_ATTR = "com.juang.thymeleaf.servlet";
    private static final String TEMPLATE_ENGINE_ATTR = "attr";
    private static final String IKI_EMBUH = "opo";

    public static void storeTemplateEngine(ServletContext context, TemplateEngine engine) {
        context.setAttribute(TEMPLATE_ENGINE_ATTR, engine);
        context.setAttribute(IKI_EMBUH, "ini EMBUHnya");
    }

    public static TemplateEngine getTemplateEngine(ServletContext context) {
        
        return (TemplateEngine) context.getAttribute(TEMPLATE_ENGINE_ATTR);
    }
}
