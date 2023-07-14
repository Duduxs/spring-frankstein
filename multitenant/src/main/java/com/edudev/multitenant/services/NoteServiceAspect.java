package com.edudev.multitenant.services;

import com.edudev.multitenant.filters.TenantContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NoteServiceAspect {

    @Before("execution(* com.edudev.multitenant.services.NoteService.*(..)) && target(noteService)")
    public void aroundExecution(JoinPoint join, NoteService noteService) throws Throwable {

        Filter filter = noteService.em
                .unwrap(Session.class)
                .enableFilter("tenantFilter");

        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
        filter.validate();

    }
}
