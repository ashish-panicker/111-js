package in.stackroute.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity Class
 * 1. @Entity annotation is used to mark the class as an entity.
 * 2. A public or protected zero argument constructor is required.
 * 3. @Table annotation is used to specify the name of the table.
 * 4. @Id annotation is used to specify the primary key.
 * 5. @Column annotation is used to specify the name of the column.
 * 6. @GeneratedValue annotation is used to specify the generation strategy.
 */

@Entity
@Table(name = "authors")
public class Author {
    
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Embedded
    private Address addres;

    public Author(){}

    public Author(int id, String name, String email, LocalDate joinDate, Address addres) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
        this.addres = addres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Address getAddres() {
        return addres;
    }

    public void setAddres(Address addres) {
        this.addres = addres;
    }

    @Override
    public String toString() {
        return String.format("Author [email=%s, id=%s, joinDate=%s, name=%s]", email, id, joinDate,
                name);
    }
        
}
