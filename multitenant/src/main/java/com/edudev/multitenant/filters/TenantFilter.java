package com.edudev.multitenant.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_BAD_REQUEST;

@Component
public class TenantFilter implements Filter {

    private static final String TENANT_HEADER = "X-Tenant";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String tHeader = req.getHeader(TENANT_HEADER);

        if (tHeader != null && !tHeader.isEmpty()) {
            TenantContext.setCurrentTenant(tHeader);
        } else {
            res.setStatus(SC_BAD_REQUEST);
        }

        chain.doFilter(request, response);


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
