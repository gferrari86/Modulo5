import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antel.PlaceBid;
import com.antel.PlaceBidBean;
import com.antel.entities.Bid;

@WebServlet(urlPatterns = "/PlaceBid")
public class ActionBazaarGUI extends HttpServlet{



     @EJB
    PlaceBid placeBidLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        Bid bid = new Bid();
        bid.setBidAmount(400);
        placeBidLocal.addBid(bid);

    }
}
