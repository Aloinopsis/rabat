package aloinopsis.rabat.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class productController {

    @GetMapping("hello")
    public String helloWorld(){
        return "Hello World";
    }
}