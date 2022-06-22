package DAO;

/**
 *
 * @author bakhoat
 */
import static DAO.DAO.session;
import Model.Auction;
import java.sql.ResultSet;
import Model.User;
import com.mysql.cj.jdbc.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;

public class AuctionDAO extends DAO {

    public AuctionDAO() {
        super();
    }

    public boolean checkLogin(User user) {
        User newuser = (User) session.createQuery("from User where username = '" + user.getUsername() + "'").uniqueResult();
        if (newuser != null && newuser.getPassword().equals(user.getPassword())) {
            user.setId(newuser.getId());
            user.setMoney(newuser.getMoney());
            user.setName(newuser.getName());
            user.setRole(newuser.getRole());
            return true;
        }
        return false;

    }

    public ArrayList<Auction> getAllAuctions() {
        ArrayList<Auction> list = (ArrayList<Auction>) session.createQuery("from Auction").list();
        System.out.println(list.size());
        return list;
    }

}
