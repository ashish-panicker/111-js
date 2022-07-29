package in.stackroute.gettingstartedspringdatajpah2.domain;

import javax.persistence.Embeddable;

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
@Embeddable
public class Address {

    private String city;
    private String state;
    private String country;
    private String pinCode;

}
