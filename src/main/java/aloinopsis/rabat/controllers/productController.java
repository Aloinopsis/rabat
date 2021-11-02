package aloinopsis.rabat.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class productController {

    private List<String> products = new ArrayList<>();

    productController() {
        products.add("Buty");
        products.add("spodnie");
        products.add("kurtki");
        products.add("czapki");
    }

    @GetMapping
    public List<String> getProducts(){
        return products;
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getProduct(@PathVariable("id") Integer id) {
        if (id > products.size() || id < 1) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Produkt nie odnaleziony");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(products.get(id - 1));
    }
}