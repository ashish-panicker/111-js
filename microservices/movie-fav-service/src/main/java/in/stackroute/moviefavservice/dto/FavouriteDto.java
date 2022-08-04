package in.stackroute.moviefavservice.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteDto {

    private String id;

    private String userName;

    private Long movieId;

    private LocalDate addedOn;
    
}
