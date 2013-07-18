package physicsobjects.factories;

import java.util.ArrayList;
import net.phys2d.raw.Body;
import net.phys2d.raw.StaticBody;
import net.phys2d.raw.shapes.Box;
import physicsobjects.AppConstants;
import physicsobjects.Main;
import physicsobjects.bodies.BarBody;
import physicsobjects.bodies.ControllerBody;
import physicsobjects.bodies.SquareBody;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class SquaresFactory {

    public static ArrayList<SquareBody> arrSquares = new ArrayList<SquareBody>(AppConstants.SQUARE_COUNT);
    public static ArrayList<SquareBody> arrSquares2 = new ArrayList<SquareBody>(AppConstants.SQUARE_COUNT);
    public static ArrayList<ControllerBody> arrControllers = new ArrayList<ControllerBody>();//(AppConstants.SQUARE_COUNT);
    public static ArrayList<BarBody> arrBars = new ArrayList<BarBody>();//(AppConstants.SQUARE_COUNT);
    public static ArrayList<BarBody> arrBars2 = new ArrayList<BarBody>();//(AppConstants.SQUARE_COUNT);
    
    public static ArrayList<SquareBody> createSquares() {
        
        for (int i = 0; i < AppConstants.SQUARE_COUNT; i++) {
            Body b = new Body(new Box(AppConstants.SQUARE_WIDTH, AppConstants.SQUARE_HEIGHT),
                    AppConstants.SQUARE_MASS);
            
            b.setPosition( (float)(Math.random() * 470 + 20),
                    (float)(Math.random() * 60 + 20));
            
            b.addExcludedBody(WallsFactory.arrWalls.get(0));
            b.setRotation(0);
            b.setRestitution(0.3f);
            b.setMaxVelocity(500, 500);
            MainFactory.world.add(b);
            arrSquares.add(0, new SquareBody(b,i));
        }
        return arrSquares;
    }
    
    public static ArrayList<SquareBody> createSquares2(int numOfSquares) {
        
        for (int i = 0; i < numOfSquares; i++) {
            Body b = new Body( new Box(AppConstants.SQUARE_WIDTH, AppConstants.SQUARE_HEIGHT), AppConstants.SQUARE_MASS);
            b.setPosition( (float)(Math.random() * 600 + 20),
                    (float)(Math.random() * 60 + 20));
            //b.setPosition(300+(50*i), -150);
            b.setRotation(0);
            b.setRestitution(0.3f);
            b.setMaxVelocity(500, 500);
            
            MainFactory.world2.add(b);
            arrSquares2.add(new SquareBody(b,i));
        }        
        return arrSquares2;
    }
    
    public static ControllerBody createMouseSquare(double oldX, double oldY){
         Body b = new StaticBody(new Box(AppConstants.CONTROLLER_WIDTH, AppConstants.CONTROLLER_HEIGHT));
         //b.setMoveable(false);
         
         float x = (float) oldX;
         float y = (float) oldY;
         b.setPosition(x,y);
         
         
         MainFactory.world.add(b);
         final ControllerBody controller = new ControllerBody(b,1);
         arrControllers.add(controller);
         Main.content.add(controller);
         return controller;
    }
    
    public static BarBody createBar(float x, float y){
         
         Body b = new Body(new Box(AppConstants.BAR_WIDTH, AppConstants.BAR_HEIGHT), 50)
                 {

                        
                        /*************/
                        
                @Override
                public strictfp void collided(Body other) {
                    super.collided(other); //To change body of generated methods, choose Tools | Templates.
                    //bottom wall ID is 0
                    if(other.getID()==0){
                        Main.collided = true;
                    }
                }
                       /*************/
                    
                
                        
                    };
         
         
         //b.setMoveable(false);
         b.setPosition(x,y);

         b.setRotation(0);
         b.setRestitution(0.3f);
         b.setMaxVelocity(500, 500);
         MainFactory.world.add(b);
         final BarBody bar = new BarBody(b,1);
         arrBars.add(bar);
         //Main.content.add(bar);
         return bar;
    }
    
    public static BarBody createBar2(float x, float y){
         
         Body b = new Body(new Box(AppConstants.BAR_WIDTH, AppConstants.BAR_HEIGHT), 50);
         
         //b.setMoveable(false);
         b.setPosition(x,y);

         b.setRotation(0);
         b.setRestitution(0.3f);
         b.setMaxVelocity(500, 500);
         MainFactory.world2.add(b);
         final BarBody bar = new BarBody(b,1);
         arrBars2.add(bar);
         //Main.content.add(bar);
         return bar;
    }
    
    public static void updateState() {
        for( SquareBody b : arrSquares ) {
            b.updateState();
        }
        
        for( ControllerBody b : arrControllers ) {
            b.updateState();
        }
        
        //arrBars.get(0).updateState();
        for( BarBody b : arrBars ) {
            b.updateState();
        }
        
    }
    
    public static void updateMenu() {
        for( BarBody b : arrBars2 ) {
            b.updateState();
        }
        
        for( SquareBody b : arrSquares2 ) {
            b.updateState();
        }
    }
}
