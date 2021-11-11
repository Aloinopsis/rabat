package aloinopsis.rabat.controllers;

import aloinopsis.rabat.models.Product;
import aloinopsis.rabat.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class productController {

    final ProductService productService;

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productToSave) {
        return productService.updateProduct(id, productToSave);
    }

    @DeleteMapping ("{id}")
    public Product delProduct(@PathVariable Long id) {
        return productService.delProduct(id);
    }
}