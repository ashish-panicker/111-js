package in.stackroute.gettingstartedspringdatajpah2.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressDto {

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Country is mandatory")
    private String state;

    @NotBlank(message = "Country is mandatory")
    private String country;

    @Digits(integer = 6, fraction = 0, message = "Pin code must be 6 digits")
    @NotEmpty(message = "Pin code is mandatory")
    private String pinCode;
    
}
