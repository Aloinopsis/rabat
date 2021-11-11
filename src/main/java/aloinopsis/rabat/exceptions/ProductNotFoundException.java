package aloinopsis.rabat.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        code = HttpStatus.NOT_FOUND,
        reason = "Produkt nie odnaleziony"
)

public class ProductNotFoundException extends RuntimeException{
}