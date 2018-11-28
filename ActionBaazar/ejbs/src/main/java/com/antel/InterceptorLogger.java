package com.antel;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorLogger {
    @AroundInvoke
    public Object logMethodEntry (InvocationContext invocationContext) throws Exception{

        long startTime = 0;
        long finishTime = 0;
        long duration = 0;

        try{
            startTime = System.currentTimeMillis();
            return invocationContext.proceed();
        } finally {
            finishTime = System.currentTimeMillis();
            duration = finishTime - startTime;
            System.out.println("InterceptorLogger en metodo: " + invocationContext.getMethod().getName() + " ejecutado en " + duration + " ms");
        }

    }

}
