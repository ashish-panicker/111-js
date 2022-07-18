package in.stackroute.shapes;

public class ShapeManager {

    private Colour colour;
    private Shape shape;

    public ShapeManager() {}

    // constructor injection
    public ShapeManager(Colour colour) {
        this.colour = colour;
    }

    // setter injection
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void draw() {
        System.out.println("Drawing " + shape.getShape() + " with " + shape.area()
                + " area and with colour as " + colour.getFillColour());
    }


}
