import database.repository.ProductDAO;
import database.repository.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.ProductService;
import service.UserService;
import test.ProductTester;
import test.UserTester;

@Configuration
public class AppConfig {

    @Bean
    public UserDAO userDAO() {
        return new UserDAO();
    }

    @Bean
    public ProductDAO productDAO() {
        return new ProductDAO();
    }

    @Bean(name = "userService")
    public UserService userService(UserDAO userDAO) {
        return new UserService(userDAO);
    }

    @Bean(name = "productService")
    public ProductService productService(ProductDAO productDAO) {
        return new ProductService(productDAO);
    }

    @Bean
    public UserTester getUserTester() {
        return new UserTester();
    }

    @Bean
    public ProductTester getProductTester() {
        return new ProductTester();
    }

}
