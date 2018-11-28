package com.antel;

import javax.ejb.Local;

@Local
public interface PlaceOrderLocal {

    public void setItemId(long itemId);

    public void setShippingAddress(String shippingAddress);

    public void setBillingAddress(String billingAddress);

    public void confirmOrder();
}
