package in.stackroute.moviefavservice.domain;

import java.time.LocalDate;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "favs")
public class Favourite {
    
    @MongoId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String userName;

    private Long movieId;

    private LocalDate addedOn;
}
