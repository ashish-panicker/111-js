package in.stackroute.shapes;

public class Colour {

    private String fillColour;

    public Colour() {
        System.out.println("Colour is created");
    }

    public Colour(String fillColour) {
        this.fillColour = fillColour;
    }

    public String getFillColour() {
        return fillColour;
    }

    public void setFillColour(String fillColour) {
        this.fillColour = fillColour;
    }

}
