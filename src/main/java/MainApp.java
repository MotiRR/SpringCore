import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ProductService;
import service.UserService;
import test.ProductTester;
import test.UserTester;

public class MainApp {

    private static void checkServices(ApplicationContext context) {
        UserService userService = context.getBean(UserService.class);
        UserTester userTester = context.getBean(UserTester.class);
        ProductService productService = context.getBean(ProductService.class);
        ProductTester productTester = context.getBean(ProductTester.class);
        userTester.testUser(userService);
        productTester.testProduct(productService);
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        checkServices(context);
    }

}
