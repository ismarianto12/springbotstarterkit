package com.edukasi.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Middleware implements HandlerInterceptor {
    public String ApiKey;

    Middleware(ConfigApp configApp) {
        this.ApiKey = configApp.getApiKey();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiHandler = request.getHeader("APP_API");
        if (apiHandler == null || apiHandler.equals("") || !apiHandler.equals(this.ApiKey)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            String paramsId = "{\"status\":\"not found\":\"http\":404}";
            response.setContentType("application/json");
            response.getWriter().println(paramsId);
            return false;
        }
        return true;
    }

}
