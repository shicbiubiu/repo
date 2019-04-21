/**
 * @ClassName: 自定义filter
 * @Description:
 * @author: shic
 * @date: 2019-04-21 16:03
 */
package com.example.demo.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        long start = System.currentTimeMillis();
        System.out.println("url:"+request.getRequestURI()+";cost:"+(System.currentTimeMillis()-start));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
