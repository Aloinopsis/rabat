package aloinopsis.rabat.services;

import aloinopsis.rabat.exceptions.ProductNotFoundException;
import aloinopsis.rabat.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 0L;

    public ProductService() {
        products.add(new Product(getNextId(),"Buty","opis pierwszego produktu", BigDecimal.valueOf(299.99)));
        products.add(new Product(getNextId(),"spodnie", "opis drugiego produktu", BigDecimal.valueOf(149.00)));
        products.add(new Product(getNextId(),"kurtki", "opis trzeciego produktu", BigDecimal.valueOf(690.50)));
        products.add(new Product(getNextId(),"czapki", "opis czwartego produktu",BigDecimal.valueOf(65.00)));
    }

    public List<Product> getProducts() {
        return products;
    }

        public Product createProduct(Product product) {
        product.setId(getNextId());
        products.add(product);
        return product;
    }
    public Product updateProduct(Long id, Product productToSave) {
        var productDb = findProduct(id);
        productToSave.setId(productDb.getId());
        products.remove(productDb);
        products.add(productToSave);
        return productToSave;
    }

    public Product delProduct(Long id) {
        var product = findProduct(id);
        products.remove(product);
        return product;
    }


    public Product getProduct(Long id) {
        return findProduct(id);
    }

    private  Long getNextId() {
        return nextId += 1;
    }

    private Product findProduct (Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException());
    }
}

