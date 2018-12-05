import com.antel.QuerysLocal;
import com.antel.entities.Order;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/Querys")
public class Querys extends HttpServlet {

    @EJB
    QuerysLocal querysLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {




        List<Order> listaOrdenesDONE;

        listaOrdenesDONE = querysLocal.findAllOrderDONE();

        System.out.println("### Consulta Ordenes en DONE ###");
        resp.getWriter().println("### Consulta Ordenes en DONE ###");

        for(Order o:listaOrdenesDONE){

            resp.getWriter().println("ItemId: " + o.getItemId() + " Status: " + o.getStatus());
            System.out.println("ItemId: " + o.getItemId() + " Status: " + o.getStatus());

        }



        List<Order> listaOrdenesBidID;
        listaOrdenesBidID = querysLocal.findAllOrderBidId(1L);


        System.out.println("### Consulta Ordenes asociadas a Bid con ID determinado ###");
        resp.getWriter().println("### Consulta Ordenes asociadas a Bid con ID determinado ###");

        for(Order o:listaOrdenesBidID){


            resp.getWriter().println("ItemId: " + o.getItemId() );
            System.out.println("ItemId: " + o.getItemId() );

        }


    }

}
