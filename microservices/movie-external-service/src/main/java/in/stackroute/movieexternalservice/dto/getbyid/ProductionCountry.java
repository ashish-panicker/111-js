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
public class ProductionCountry {
    
        @JsonProperty("iso_3166_1")
        private String iso31661;
    
        @JsonProperty("name")
        private String name;
    

}
