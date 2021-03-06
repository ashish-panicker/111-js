package in.stackroute.shapes;

public class Circle implements Shape {

    private double radius;

    public Circle() {
        System.out.println("Circle is created");
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14 * (radius * radius);

    }

    @Override
    public String getShape() {
        return "Circle";
    }

  

}
