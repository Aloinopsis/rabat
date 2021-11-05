package aloinopsis.rabat.controllers;

import aloinopsis.rabat.exceptions.ProductNotFoundException;
import aloinopsis.rabat.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class productController {

    private List<Product> products = new ArrayList<>();

    productController() {
        products.add(new Product(1L,"Buty"));
        products.add(new Product(2L,"spodnie"));
        products.add(new Product(4L,"kurtki"));
        products.add(new Product(7L,"czapki"));
    }

    @GetMapping
    public List<Product> getProducts(){
        return products;
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException());
    }
}