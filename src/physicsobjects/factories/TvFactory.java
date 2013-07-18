package physicsobjects.factories;

import java.util.ArrayList;
import net.phys2d.math.Vector2f;
import net.phys2d.raw.BasicJoint;
import net.phys2d.raw.Body;
import net.phys2d.raw.StaticBody;
import net.phys2d.raw.shapes.Box;
import physicsobjects.AppConstants;
import physicsobjects.bodies.TvBody;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class TvFactory {

    private static ArrayList<TvBody> arrTvs = new ArrayList<TvBody>(1);

    public static ArrayList<TvBody> createTv() {

        Body b = new Body(new Box(AppConstants.TV_WIDTH, AppConstants.TV_HEIGHT),
                AppConstants.TV_MASS);
        b.setPosition(AppConstants.WALL_WIDTH / 2, 150);
        b.setFriction(1);
        MainFactory.world.add(b);
        
        Body anchor = new StaticBody( new Box(1,1) );
        anchor.setPosition(AppConstants.WALL_WIDTH/2, 0);
        MainFactory.world.add(anchor);
        
        BasicJoint joint = new BasicJoint(anchor,b,new Vector2f( anchor.getPosition().getX(),
            anchor.getPosition().getY()));
        MainFactory.world.add(joint);
        arrTvs.add(new TvBody(b, anchor, joint));
        
        return arrTvs;
    }

    public static void updateState() {
        for (TvBody b : arrTvs) {
            b.updateState();
        }
    }
}
