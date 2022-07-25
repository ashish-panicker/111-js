package in.stackroute.boot.domain;

import java.util.List;

public class Learner {

    private Integer id;
    private String name;
    private String email;
    private List<String> tracks;
    private Address address;

    public Learner() {
    }

    public Learner(Integer id, String name, String email, List<String> tracks, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tracks = tracks;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("Learner [address=%s, email=%s, id=%s, name=%s, tracks=%s]", address,
                email, id, name, tracks);
    }

    
    
}
