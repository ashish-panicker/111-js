package in.stackroute.gettingstartedspringdatajpah2.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "mentors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mentor {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @ElementCollection
    private List<String> technologies;

    private LocalDate joinDate;

    @Embedded
    private Address address;

}
