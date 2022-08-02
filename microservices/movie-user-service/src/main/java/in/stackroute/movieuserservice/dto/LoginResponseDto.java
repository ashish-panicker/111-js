package in.stackroute.movieuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String userName;

    private String token;
    
    private boolean isValid;
    
}
