package in.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.stackroute.shapes.ShapeManager;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("beans.xml");

        ShapeManager shapeManager;
        
        shapeManager = context.getBean("shapeManagerCircle", ShapeManager.class);
        shapeManager.draw();

        shapeManager = context.getBean("shapeManagerSquare", ShapeManager.class);
        shapeManager.draw();


    }
}
