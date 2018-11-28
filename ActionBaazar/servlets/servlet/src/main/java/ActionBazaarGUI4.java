import com.antel.EnviarOrden;
import com.antel.PlaceOrderLocal;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

@WebServlet(urlPatterns = "/PlaceOrder3")
public class ActionBazaarGUI4 extends HttpServlet {



    // Para cada sesion hago un lookup para instanciar un sessionBean distinto.
    // Además se crea la sesion sin boton init

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {



        String operation = req.getParameter("operation");
        String parameter = req.getParameter("parameter");

        HttpSession httpSession = req.getSession();

        PlaceOrderLocal placeOrderLocal = (PlaceOrderLocal) httpSession.getAttribute("placeOrder");

        if (placeOrderLocal == null){

            try{
                InitialContext ic = new InitialContext();
                placeOrderLocal =
                        (PlaceOrderLocal)ic.lookup("java:app/ejbs-1.0-SNAPSHOT/PlaceOrderBean");

                httpSession.setAttribute("placeOrder", placeOrderLocal);

            } catch (NamingException e) {
                e.printStackTrace();
            }

        }

        if("shippingAddress".equals(operation)){

            placeOrderLocal.setShippingAddress(parameter);
        } else if("billingAddress".equals(operation)){

            placeOrderLocal.setBillingAddress(parameter);
        } else if("itemid".equals(operation)){

            placeOrderLocal.setItemId(Long.parseLong(parameter));
        }else if("confirm".equals(operation)){

            placeOrderLocal.confirmOrder();
            // con el siguiente comando borro placeOrder para que se pueda crear otro
            httpSession.setAttribute("placeOrder", null);

        }

    }

}
