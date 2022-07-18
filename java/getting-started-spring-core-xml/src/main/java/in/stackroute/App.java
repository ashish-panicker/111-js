package in.stackroute;

import in.stackroute.shapes.Circle;
import in.stackroute.shapes.Colour;
import in.stackroute.shapes.ShapeManager;
import in.stackroute.shapes.Square;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ShapeManager shapeManager = new ShapeManager();

        Circle circle = new Circle(10);
        shapeManager.setShape(circle);
        shapeManager.setColour(new Colour("red"));
        shapeManager.draw();

        Square square = new Square(10);
        shapeManager.setShape(square);
        shapeManager.setColour(new Colour("blue"));
        shapeManager.draw();

    }
}
