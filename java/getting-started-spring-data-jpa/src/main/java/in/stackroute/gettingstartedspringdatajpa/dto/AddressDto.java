package in.stackroute.gettingstartedspringdatajpa.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Country is mandatory")
    private String state;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @NotBlank(message = "Pin code is mandatory")
    @Digits(integer = 6, fraction = 0, message = "Pin code must be 6 digits")
    private String pinCode;
    
}
