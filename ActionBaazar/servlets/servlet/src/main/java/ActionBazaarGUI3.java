import com.antel.PlaceOrderLocal;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/PlaceOrder2")
public class ActionBazaarGUI3 extends HttpServlet {



    // Para cada sesion hago un lookup para instanciar un sessionBean distinto.

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {



        String operation = req.getParameter("operation");
        String parameter = req.getParameter("parameter");

        HttpSession httpSession = req.getSession();

        if("init".equals(operation)){
           try{
               InitialContext ic = new InitialContext();
               PlaceOrderLocal placeOrderLocal =
                       (PlaceOrderLocal)ic.lookup("java:app/ejbs-1.0-SNAPSHOT/PlaceOrderBean");

               httpSession.setAttribute("placeOrder", placeOrderLocal);

           } catch (NamingException e) {
               e.printStackTrace();
           }
        } else if("shippingAddress".equals(operation)){
            PlaceOrderLocal placeOrderLocal = (PlaceOrderLocal) httpSession.getAttribute("placeOrder");
            placeOrderLocal.setShippingAddress(parameter);
        } else if("billingAddress".equals(operation)){
            PlaceOrderLocal placeOrderLocal = (PlaceOrderLocal) httpSession.getAttribute("placeOrder");
            placeOrderLocal.setBillingAddress(parameter);
        } else if("itemid".equals(operation)){
            PlaceOrderLocal placeOrderLocal = (PlaceOrderLocal) httpSession.getAttribute("placeOrder");
            placeOrderLocal.setItemId(Long.parseLong(parameter));
        }else if("confirm".equals(operation)){
            PlaceOrderLocal placeOrderLocal = (PlaceOrderLocal) httpSession.getAttribute("placeOrder");
            placeOrderLocal.confirmOrder();
        }

    }

}
