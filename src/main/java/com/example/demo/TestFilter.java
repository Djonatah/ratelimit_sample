package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
public class TestFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var param = servletRequest.getParameter("msg");
        if(param instanceof String msg)
            System.out.println("filter test> " + msg);
        if(servletRequest instanceof HttpServletRequest httpReq){
            System.out.println("ip> " + httpReq.getRemoteAddr());
            System.out.println("fwded ip> " + httpReq.getHeader("X-FORWARDED-FOR"));
            System.out.println("real ip> " + httpReq.getHeader("X-REAL-IP"));

        }else{
            System.out.println("not httpservlet");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}


