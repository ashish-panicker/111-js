package in.stackroute.gettingstartedspringdatajpamongo.domain;

import java.time.LocalDate;
import java.util.List;
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
@Document(collection = "mentors")
public class Mentor {

    @MongoId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String name;

    private String email;

    private List<String> technologies;

    private LocalDate joinDate;

    private Address address;

}
