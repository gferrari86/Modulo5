package com.antel;

import com.antel.entities.Order;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorBillOrder {
    @AroundInvoke
    public Object logMethodEntry (InvocationContext invocationContext) throws Exception{
        System.out.println("InterceptorBillOrder en metodo: " + invocationContext.getMethod().getName());

        Object[] params = invocationContext.getParameters();
        params[0] = new String("Direccion Interceptada");

        invocationContext.setParameters(params);
        return invocationContext.proceed();

    }
}
