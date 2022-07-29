package in.stackroute.gettingstartedspringdatajpah2.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class MentorDto {

    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "Technologies is mandatory")
    private List<String> technologies;

    @NotNull(message = "Join date is mandatory")
    private LocalDate joinDate;

    private AddressDto address;
    
}
