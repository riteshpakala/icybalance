package physicsobjects.factories;

import java.util.ArrayList;
import net.phys2d.raw.Body;
import net.phys2d.raw.StaticBody;
import net.phys2d.raw.shapes.Box;
import physicsobjects.AppConstants;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class WallsFactory {
    
    public static ArrayList<Body> arrWalls = new ArrayList<Body>(4);
    
    public static void createWalls() {
        
        Body southWall = new StaticBody( new Box(AppConstants.WALL_WIDTH, AppConstants.WALL_HEIGHT) );
        southWall.setPosition(AppConstants.WALL_WIDTH/2, AppConstants.WALL_WIDTH-(AppConstants.WALL_HEIGHT/2) +31);
        southWall.setRestitution(AppConstants.WALL_RESTITUTION);
        southWall.setFriction(AppConstants.WALL_FRICTION);
        
        arrWalls.add(southWall);
        MainFactory.world.add(southWall);
        MainFactory.world2.add(southWall);
        
        Body northWall = new StaticBody( new Box(AppConstants.WALL_WIDTH, AppConstants.WALL_HEIGHT) );
        northWall.setPosition(AppConstants.WALL_WIDTH/2, (AppConstants.WALL_HEIGHT/2)-10);
        northWall.setRestitution(AppConstants.WALL_RESTITUTION);
        northWall.setFriction(AppConstants.WALL_FRICTION);
        
        arrWalls.add(northWall);
        //MainFactory.world.add(northWall);
        MainFactory.world2.add(northWall);
        
        Body eastWall = new StaticBody( new Box(AppConstants.WALL_WIDTH+30, AppConstants.WALL_HEIGHT) );
        eastWall.setPosition(AppConstants.WALL_WIDTH-(AppConstants.WALL_HEIGHT/2)+5,
                AppConstants.WALL_WIDTH/2);
        eastWall.setRotation((float)Math.toRadians(90));
        eastWall.setRestitution(AppConstants.WALL_RESTITUTION);
        eastWall.setFriction(AppConstants.WALL_FRICTION);
        
        arrWalls.add(eastWall);
        MainFactory.world.add(eastWall);
        MainFactory.world2.add(eastWall);
        
        Body westWall = new StaticBody( new Box(AppConstants.WALL_WIDTH+30, AppConstants.WALL_HEIGHT) );
        westWall.setPosition((AppConstants.WALL_HEIGHT/2)+3,
                AppConstants.WALL_WIDTH/2);
        westWall.setRotation((float)Math.toRadians(90));
        westWall.setRestitution(AppConstants.WALL_RESTITUTION);
        westWall.setFriction(AppConstants.WALL_FRICTION);
        
        arrWalls.add(westWall);
        MainFactory.world.add(westWall);
        MainFactory.world2.add(westWall);
        
    }
    
}
