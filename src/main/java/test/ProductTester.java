package test;

import database.dto.Product;
import service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductTester {


    private void printProduct(ProductService productService, Long id) {
        Product product = productService.getProductById(id);
        if (product != null)
            System.out.println(product);
    }

    private void printAllUsers(ProductService productService) {
        List<Product> productList = productService.getAllProducts();
        if (productList != null && !productList.isEmpty())
            productList.forEach(System.out::println);
    }

    private void saveProduct(ProductService productService, Product product) {
        productService.saveProduct(product);
    }


    public void testProduct(ProductService productService) {
        printProduct(productService, 1L);
        printAllUsers(productService);
        saveProduct(productService, new Product("paper", BigDecimal.valueOf(500)));
    }
}
