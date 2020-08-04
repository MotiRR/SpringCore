package database.repository;

import database.DataBaseManager;
import database.dto.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductDAO {

    public void saveProduct(Product product) {
        try (Session session = DataBaseManager.getInstance().getSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getProductById(Long id) {
        Product product = null;
        try (Session session = DataBaseManager.getInstance().getSession()) {
            session.beginTransaction();
            product = session.find(Product.class, id);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getAllProducts() {
        List products = null;
        try (Session session = DataBaseManager.getInstance().getSession()) {
            session.beginTransaction();
            products = session.createQuery("Select u FROM Product u")
                    .getResultList();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

}
