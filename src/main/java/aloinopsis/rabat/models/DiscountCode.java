package aloinopsis.rabat.models;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class DiscountCode {

    private Long id;

    @Size(min = 2, max = 8, message = "Kod rabatowy musi zawierać od 2 do 8 cyfr")
    @Pattern(regexp = "^[0-9]{2,8}$", message = "Kod rabatowy przyjmuje wyłącznie cyfry")
    private String DiscountCode;
}
