package com.antel;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorMessage {
    @AroundInvoke
    public Object logMethodEntry (InvocationContext invocationContext) throws Exception{
        System.out.println("Interceptor en metodo: " + invocationContext.getMethod().getName());
        return invocationContext.proceed();

    }
}
