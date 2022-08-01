package in.stackroute.movieexternalservice.dto.search;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchReponse {

    private String page;

    private List<MovieSearch> results;

    @JsonProperty("total_pages")
    private String totalResults;

    @JsonProperty("total_results")
    private String totalPages;


}
