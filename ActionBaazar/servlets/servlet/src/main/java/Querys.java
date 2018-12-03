import com.antel.QuerysLocal;
import com.antel.entities.Order;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Querys")
public class Querys extends HttpServlet {

    @EJB
    QuerysLocal querysLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp){


        List<Order> listaOrdenesDONE = new ArrayList<Order>();

        listaOrdenesDONE = querysLocal.findAllOrderDONE();

        System.out.println("### Consulta Query ###");

        for(Order o:listaOrdenesDONE){

            System.out.println("ItemId: " + o.getItemId() + "Status: " + o.getStatus());

        }


    }

}
