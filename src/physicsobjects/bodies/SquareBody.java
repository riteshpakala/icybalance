package physicsobjects.bodies;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import net.phys2d.raw.Body;
import net.phys2d.raw.shapes.Box;
import physicsobjects.AppConstants;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class SquareBody extends Rectangle {
    
    private Body body;
    private int id;
    

    public SquareBody(final Body body, int id) {
        super(((Box)(body.getShape())).getSize().getX(), ((Box)(body.getShape())).getSize().getY(),
                new LinearGradient(0f, 0f, .5f, 1f, true, CycleMethod.NO_CYCLE, new 
         Stop[]{
            new Stop(0, Color.AQUAMARINE),
            new Stop(1, Color.ALICEBLUE)
            }));
        
        super.setStroke(Color.web("#575656"));
        
        this.body = body;
        this.id = id;
        this.setCache(true);
        this.setX((double)body.getPosition().getX() - (getWidth()/2));
        this.setY((double)body.getPosition().getY() - (getHeight()/2));
                        
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                float mx = (float) me.getSceneX();
                float my = (float) me.getSceneY();
                float bx = (float) getX();
                float by = (float) getY();
                body.setForce( (mx -  bx ) * (body.getMass() * 7), (my - by ) * (body.getMass() * 7));
            }
        });
        
    }
    

    public SquareBody() {
    }

    
    
    public void updateState() {
        this.setX((double)body.getPosition().getX() - (AppConstants.SQUARE_WIDTH/2));
        this.setY((double)body.getPosition().getY() - (AppConstants.SQUARE_HEIGHT/2));
        this.setRotate(Math.toDegrees(body.getRotation()));
        
        
    }

    public Body getBody(){
        return body;
    }
    
}
