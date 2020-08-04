package service;

import database.dto.Product;
import database.dto.User;
import database.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void saveProduct(Product product) {
        productDAO.saveProduct(product);
    }

    public Product getProductById(Long id) {
        return productDAO.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
}
