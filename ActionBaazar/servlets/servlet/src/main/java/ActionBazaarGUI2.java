import com.antel.PlaceBidBean;
import com.antel.PlaceOrderBean;
import com.antel.PlaceOrderLocal;
import com.antel.entities.Bid;
import com.antel.entities.Order;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/PlaceOrder")
public class ActionBazaarGUI2 extends HttpServlet {

    @EJB
    PlaceOrderLocal placeOrderLocal;

    // Problema de que todas las sesiones web apuntan al mismo ejb stateful

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String operation = req.getParameter("operation");
        String parameter = req.getParameter("parameter");

        if("shippingAddress".equals(operation)){
           placeOrderLocal.setShippingAddress(parameter);
        } else if("billingAddress".equals(operation)){
            placeOrderLocal.setBillingAddress(parameter);
        } else if("itemid".equals(operation)){
            placeOrderLocal.setItemId(Long.parseLong(parameter));
        }else if("confirm".equals(operation)){
            placeOrderLocal.confirmOrder();
        }

    }

}
