package physicsobjects.bodies;

import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import net.phys2d.raw.BasicJoint;
import net.phys2d.raw.Body;
import physicsobjects.AppConstants;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class TvBody extends Group {

    private Body body;
    private Body anchor;
    private BasicJoint joint;
    private Rectangle frame;
    Line rope;
    MediaView mv;

    
    public TvBody(Body body, Body anchor, BasicJoint joint) {
        super();
        this.body = body;
        this.anchor = anchor;
        this.joint = joint;
        
        rope = new Line(anchor.getPosition().getX(), anchor.getPosition().getY(),
                (double)body.getPosition().getX(), (double)body.getPosition().getY());
        rope.setStroke(Color.BROWN);
        rope.setCache(true);
        this.getChildren().add(rope);
        
        frame = new Rectangle(AppConstants.TV_WIDTH, AppConstants.TV_HEIGHT,Color.DARKORCHID);
        frame.setCache(true);
        frame.setX((double)body.getPosition().getX() - (AppConstants.TV_WIDTH/2));
        frame.setY((double)body.getPosition().getY() - (AppConstants.TV_HEIGHT/2));
        this.getChildren().add(frame);
        
//        MediaPlayer mediaPlayer = new MediaPlayer(new Media(AppConstants.TV_SOURCE));
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.setVolume(0.5);
//        mediaPlayer.setCycleCount(1);
//
//        mv = new MediaView(mediaPlayer);
//        mv.setFitWidth(AppConstants.TV_WIDTH);
//        mv.setFitHeight(AppConstants.TV_HEIGHT);
//        mv.setX((double)body.getPosition().getX() - (AppConstants.TV_WIDTH/2));
//        mv.setY((double)body.getPosition().getY() - (AppConstants.TV_HEIGHT/2));
//        this.getChildren().add(mv);
        
    }
    
    public TvBody() {
    }
    
    public void updateState() {
        frame.setX((double)body.getPosition().getX() - (AppConstants.TV_WIDTH/2));
        frame.setY((double)body.getPosition().getY() - (AppConstants.TV_HEIGHT/2));
        frame.setRotate(Math.toDegrees(body.getRotation()));
        rope.setEndX((double)body.getPosition().getX());
        rope.setEndY((double)body.getPosition().getY());
//        mv.setX((double)body.getPosition().getX() - (AppConstants.TV_WIDTH/2));
//        mv.setY((double)body.getPosition().getY() - (AppConstants.TV_HEIGHT/2));
//        mv.setRotate(Math.toDegrees(body.getRotation()));
    }
    
}
