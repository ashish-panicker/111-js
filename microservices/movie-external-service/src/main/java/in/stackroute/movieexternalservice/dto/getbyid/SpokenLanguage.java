package in.stackroute.movieexternalservice.dto.getbyid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpokenLanguage {

    @JsonProperty("english_name")
    private String englishName;

    @JsonProperty("iso_639_1")
    private String iso6391;
    
    @JsonProperty("name")
    private String name;
    
    

}
