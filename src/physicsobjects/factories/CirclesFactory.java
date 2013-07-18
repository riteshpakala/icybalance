package physicsobjects.factories;

import java.util.ArrayList;
import java.util.Random;
import net.phys2d.raw.Body;
import net.phys2d.raw.shapes.Circle;
import physicsobjects.AppConstants;
import physicsobjects.bodies.CircleBody;
import physicsobjects.factories.WallsFactory;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class CirclesFactory {
    
    public static ArrayList<CircleBody> arrCircles = new ArrayList<CircleBody>(AppConstants.CIRCLE_COUNT);
    public static ArrayList<CircleBody> arrCircles2 = new ArrayList<CircleBody>();
    
    public static ArrayList<CircleBody> createCircles() {
        
        for (int i = 0; i < AppConstants.CIRCLE_COUNT; i++) {
            Body b = new Body( new Circle(AppConstants.CIRCLE_RADIUS), AppConstants.CIRCLE_MASS );
            b.setPosition( (float)(Math.random() * 470 + 20),
                    -50);
            
            b.addExcludedBody(WallsFactory.arrWalls.get(0));
            b.setRotation(0);
            b.setRestitution(0.3f);
            b.setMaxVelocity(500, 500);
            MainFactory.world.add(b);
            arrCircles.add(0, new CircleBody(b,i));
        }        
        return arrCircles;
    }
    
    public static ArrayList<CircleBody> createCircles2(int numOfCircles) {
        
        for (int i = 0; i < numOfCircles; i++) {
            Body b = new Body( new Circle(AppConstants.CIRCLE_RADIUS), AppConstants.CIRCLE_MASS );
            b.setPosition( (float)(Math.random() * 600 + 20),
                    (float)(Math.random() * 60));
            //b.setPosition(200+(50*i), -100);
            b.setRotation(0);
            b.setRestitution(0.3f);
            b.setMaxVelocity(500, 500);
            
            MainFactory.world2.add(b);
            arrCircles2.add(new CircleBody(b,i));
        }        
        return arrCircles2;
    }
    
    public static void updateState() {
        for( CircleBody b : arrCircles ) {
            b.updateState();
        }
        
    }
    
    public static void updateMenu() {
        for( CircleBody b : arrCircles2 ) {
            b.updateState();
        }
    }
    
}
