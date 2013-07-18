package physicsobjects.factories;

import java.util.ArrayList;
import net.phys2d.math.Vector2f;
import net.phys2d.raw.World;
import net.phys2d.raw.strategies.QuadSpaceStrategy;
import physicsobjects.AppConstants;
import physicsobjects.Main;
import physicsobjects.bodies.CircleBody;
import physicsobjects.bodies.SquareBody;
import physicsobjects.bodies.TvBody;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class MainFactory {
    
    public static World world;
    public static World world2;

    
    public static void createWorld() {
        world = new World(new Vector2f(AppConstants.WORLD_GRAVITY_X, AppConstants.WORLD_GRAVITY_Y)
                ,20, new QuadSpaceStrategy(20,5));
          
        world2 = new World(new Vector2f(AppConstants.WORLD_GRAVITY_X, AppConstants.WORLD_GRAVITY_Y)
                ,20, new QuadSpaceStrategy(20,5));
    }
    
    public static void createWalls(){
        WallsFactory.createWalls();        
    }
    
    public static void createSquares() {
        ArrayList<SquareBody> l = SquaresFactory.createSquares();
        for( SquareBody b : l ) {
            Main.content.add(b);
        }
    }
    
    public static void updateSquares() {
        SquaresFactory.updateState();
    }
    
    public static void createCircles() {
        ArrayList<CircleBody> l = CirclesFactory.createCircles();
        for( CircleBody b : l ) {
            Main.content.add(b);
        }
    }
    
    public static void updateCircles() {
        CirclesFactory.updateState();
    }
    
    public static void createTv() {
        ArrayList<TvBody> l = TvFactory.createTv();
        for( TvBody b : l ) {
            Main.content.add(b);
        }
    }
    
    public static void updateTv() {
        TvFactory.updateState();
        
    }
    
    public static void createAll() {
        createWorld();
        createWalls();
        //createTv();
        //createSquares();
        //createCircles();
    }
    
    public static void updateAll(){
        updateTv();
        updateSquares();
        updateCircles();
    }
    
    public static void updateMenu(){
        SquaresFactory.updateMenu();
        CirclesFactory.updateMenu();
    }
    
    public static void doMenuStep(){
        world2.step();
    }
    
    public static void doMenuStep(float step){
        world2.step(step);
    }
    
    public static void doStep(){
        world.step();
    }
    
}
