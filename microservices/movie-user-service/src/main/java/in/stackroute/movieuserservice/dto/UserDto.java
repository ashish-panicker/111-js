package in.stackroute.movieuserservice.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    
    private Integer userId;

    private String userName;

    private String password;

    private String email;

    private LocalDate joinDate;
}
