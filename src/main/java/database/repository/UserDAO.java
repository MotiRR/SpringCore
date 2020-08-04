package database.repository;

import database.DataBaseManager;
import database.dto.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO {

    public void saveUser(User user) {
        try (Session session = DataBaseManager.getInstance().getSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(Long id) {
        User user = null;
        try (Session session = DataBaseManager.getInstance().getSession()) {
            session.beginTransaction();
            user = session.find(User.class, id);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List users = null;
        try (Session session = DataBaseManager.getInstance().getSession()) {
            session.beginTransaction();
            users = session.createQuery("Select u FROM User u")
                    .getResultList();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
