package physicsobjects.bodies;

import javafx.event.EventHandler;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import net.phys2d.raw.Body;
import physicsobjects.AppConstants;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */

public class CircleBody extends Circle {
    
    private Body body;
    private int id;
    
    public CircleBody(final Body body, int id) {
        super(AppConstants.CIRCLE_RADIUS,
                new LinearGradient(0f, 0f, .5f, 1f, true, CycleMethod.NO_CYCLE, new 
         Stop[]{
            new Stop(0, Color.web("#F5F5F5")),
            new Stop(1, Color.LIGHTSLATEGRAY)
            }));
        
        super.setStroke(Color.web("#575656"));
        
        this.body = body;
        this.id = id;
        this.setCache(true);
        setCenterX((double)body.getPosition().getX());
        setCenterY((double)body.getPosition().getY());
                
        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                float mx = (float) me.getSceneX();
                float my = (float) me.getSceneY();
                float bx = (float) getCenterX();
                float by = (float) getCenterY();
                body.setForce( (mx -  bx ) * (body.getMass() * 7), (my - by ) * (body.getMass() * 7));
            }
        });
    }

    public CircleBody() {
    }
    
    public void updateState() {
        this.setCenterX((double)body.getPosition().getX());
        this.setCenterY((double)body.getPosition().getY());
        this.setRotate(Math.toDegrees(body.getRotation()));
    }    
    
}
