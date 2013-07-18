/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physicsobjects.bodies;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import net.phys2d.raw.Body;
import net.phys2d.raw.shapes.Box;
import physicsobjects.AppConstants;


public class BarBody extends Rectangle {
    
    private Body body;
    private int id;
    private Rectangle clip;

    public BarBody(final Body body, int id) {
        super(((Box)(body.getShape())).getSize().getX(), ((Box)(body.getShape())).getSize().getY(),
                Color.web("#585757"));
        super.setArcHeight(20);
        super.setArcWidth(20);
        
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(3);
        innerShadow.setOffsetY(3);
        innerShadow.setColor(Color.web("#000000"));
        //super.setEffect(innerShadow);
        
        /*DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(2);
        dropShadow.setSpread(1);
        dropShadow.setRadius(1);
        dropShadow.setInput(innerShadow);
        dropShadow.setColor(Color.web("#49f4ff"));
        super.setEffect(dropShadow);*/
        super.setEffect(innerShadow);
        
       
        this.clip = new Rectangle(640, 62);
        
        
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
    

    public BarBody() {
    }

    
    
    public void updateState() {
        this.setX((double)body.getPosition().getX() - (AppConstants.SQUARE_WIDTH*13+1));
        this.setY((double)body.getPosition().getY() - (AppConstants.SQUARE_HEIGHT+7));
        this.setRotate(Math.toDegrees(body.getRotation()));
        
        
    }

    public Body getBody(){
        return body;
    }
    
}

