package physicsobjects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.util.Duration;
import net.phys2d.math.Vector2f;
import physicsobjects.bodies.BarBody;
import physicsobjects.bodies.CircleBody;
import physicsobjects.bodies.ControllerBody;
import physicsobjects.bodies.SquareBody;
import physicsobjects.factories.CirclesFactory;
import physicsobjects.factories.MainFactory;
import physicsobjects.factories.SquaresFactory;

/**
 *
 * @author Ritesh Pakala
 * www.icypixel.net
 */
public class Main extends Application {
    
    
    
    public static Scene scene, scene2, scene3, scene4;
    public static ObservableList<Node> content, content2, content3, content4, content5;
    public static boolean collided = false;
    
    private static Stage stage;
    private static Label label, label2, labelScore;
    private static BarBody b0, b2;
    private static ControllerBody b1;
    //private static final Timeline everySecond = new Timeline();
    private static final Timeline everySecond2 = new Timeline();
    private static String verified = "";
    private static int timer = 0;
    private static int counter = 1;
    private static int counter2 = 1;
    private static int counter3 = 1;
    private static int score = 0;
    private static Button menu = new Button("Menu");
    private static Button restart = new Button("Restart");
    private static Button menu2 = new Button("Menu");
    private static Button restart2 = new Button("Restart");
    private static Button pause = new Button("Pause");
    
    
    private final Font visitor = Font.loadFont(getClass().getResourceAsStream("res/visitor2.ttf"), 40);
    
    @Override
    public void start(final Stage primaryStage){ 
 
        /***************************/
        /***** Initialization  *****/
        /***************************/
        
        primaryStage.setTitle("IcyBalance - OFFLINE - Beta v1.0");
        stage = primaryStage;
        scene = new Scene(new Group(), AppConstants.APP_WIDTH, AppConstants.APP_HEIGHT, Color.WHITE);
        content = ((Group) scene.getRoot()).getChildren();
        
        scene2 = new Scene(new Group(), AppConstants.APP_WIDTH, AppConstants.APP_HEIGHT, Color.WHITE);
        content2 = ((Group) scene2.getRoot()).getChildren();
        
        scene3 = new Scene(new Group(), AppConstants.APP_WIDTH, AppConstants.APP_HEIGHT, Color.WHITE);
        content4 = ((Group) scene3.getRoot()).getChildren();
        
        scene4 = new Scene(new Group(), AppConstants.APP_WIDTH, AppConstants.APP_HEIGHT, Color.WHITE);
        content5 = ((Group) scene4.getRoot()).getChildren();
        
        
        Image bgd = new Image(getClass().getResourceAsStream("res/bgd.png"));
        Image logo = new Image(getClass().getResourceAsStream("res/logo.png"));
       
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        /***************************/
        /*********** MENU  *********/
        /***************************/
        
        Button play = new Button("Play");
        play.setTranslateX(AppConstants.WALL_WIDTH/2 - 20);
        play.setTranslateY(450);
        
        Button htp = new Button("How to Play");
        htp.setTranslateX(AppConstants.WALL_WIDTH/2 - 45);
        htp.setTranslateY(500);
        
        Button cred = new Button("Credits");
        cred.setTranslateX(AppConstants.WALL_WIDTH/2 - 30);
        cred.setTranslateY(550);
        
        
        htp.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(scene3);
                                        
                                     }
                                    });
        
        cred.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(scene4);
                                        
                                     }
                                    });
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        /***************************/
        /*******HOW TO PLAY*********/
        /***************************/
        final Canvas canvasHtp = new Canvas(690,720);
        final GraphicsContext gc3 = canvasHtp.getGraphicsContext2D();
        
        gc3.drawImage(bgd, (double)0, (double)0, (double)690, (double)720);
        
        Image htpImg = new Image(getClass().getResourceAsStream("res/htp.png"));
        gc3.drawImage(htpImg, (double)0, (double)0, (double)690, (double)720);
        
        gc3.drawImage(logo, (double)600, (double)700, (double)80, (double)15);
        
        Button back = new Button("Back");
        back.setTranslateX(10);
        back.setTranslateY(693);
        
        back.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(scene2);
                                        
                                     }
                                    });
        
        content4.addAll(canvasHtp, back);
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        /***************************/
        /********* CREDITS *********/
        /***************************/
        final Canvas canvasCred = new Canvas(690,720);
        final GraphicsContext gc4 = canvasCred.getGraphicsContext2D();
       
        gc4.drawImage(bgd, (double)0, (double)0, (double)690, (double)720);
        
        Image credImg = new Image(getClass().getResourceAsStream("res/cred.png"));
        gc4.drawImage(credImg, (double)0, (double)0, (double)690, (double)720);
        
        Image phys2dImg = new Image(getClass().getResourceAsStream("res/phys2d.png"));
        Image website = new Image(getClass().getResourceAsStream("res/website.png"));
        Image twitter = new Image(getClass().getResourceAsStream("res/twitter.png"));
        
        Hyperlink link = new Hyperlink();
        Hyperlink link2 = new Hyperlink();
        Hyperlink link3 = new Hyperlink();
        link.setGraphic(new ImageView(phys2dImg));
        link2.setGraphic(new ImageView(website));
        link3.setGraphic(new ImageView(twitter));
        
        link.setTranslateX(430);
        link.setTranslateY(230);
        
        link2.setTranslateX(48);
        link2.setTranslateY(480);
        
        link3.setTranslateX(57);
        link3.setTranslateY(510);
        
        link.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    
                    getHostServices().showDocument("http://www.cokeandcode.com/index.html?page=libs");
                    
                }
            });
        
        link2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    
                    getHostServices().showDocument("http://www.icypixel.net");
                    
                }
            });
        
        link3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e){
                    
                    getHostServices().showDocument("http://www.twitter.com/riteshpakala");
                    
                }
            });
        
        gc4.drawImage(logo, (double)600, (double)700, (double)80, (double)15);
        
        Button back2 = new Button("Back");
        back2.setTranslateX(10);
        back2.setTranslateY(693);
        
        back2.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(scene2);
                                        
                                     }
                                    });
        
        content5.addAll(canvasCred, back2, link, link2, link3);
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        /***************************/
        /*********** Score  *********/
        /***************************/
        
        labelScore = new Label("Score: "+score);
        labelScore.setTranslateX(10);
        labelScore.setTranslateY(5);
        labelScore.setTextFill(Color.web("#575656"));
        labelScore.setFont(visitor);
        
        //labelScore.setFont(Font.font("Verdana", 24));
        
        /***************************/
        /***************************/
        /***************************/
        
        
        
        /***************************/
        /*****   BACKGROUND  *******/
        /***************************/
        
        final Canvas canvas = new Canvas(690,720);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        final Canvas canvasMenu = new Canvas(690,720);
        final GraphicsContext gc2 = canvasMenu.getGraphicsContext2D();
        
        
        gc.drawImage(bgd, (double)0, (double)0, (double)690, (double)720);
        Image gameLogo = new Image(getClass().getResourceAsStream("res/gameLogo.png"));
        gc.drawImage(gameLogo, (double)510, (double)10, (double)170, (double)18);
        
        gc.drawImage(logo, (double)600, (double)700, (double)80, (double)15);
        
        /*******MENU CANVAS********/
        gc2.drawImage(bgd, (double)0, (double)0, (double)690, (double)720);
        
        Image header = new Image(getClass().getResourceAsStream("res/header.png"));
        gc2.drawImage(header, (double)60, (double)100, (double)559, (double)166);
        
        Image ver = new Image(getClass().getResourceAsStream("res/ver.png"));
        gc2.drawImage(ver, (double)150, (double)350, (double)386, (double)39);
        
        gc2.drawImage(logo, (double)600, (double)700, (double)80, (double)15);
        
        /**************************/
        
        content.add(canvas);
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        /***************************/
        /********** ~~~~ ***********/
        /***************************/
        
       
        final Slider hslider = new Slider(-300, 300, AppConstants.WORLD_GRAVITY_X);
        final Slider vslider = new Slider(-300, 300, AppConstants.WORLD_GRAVITY_Y);
        
        
        
        hslider.valueProperty().addListener( new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    MainFactory.world.setGravity(new_val.floatValue(), (float)vslider.getValue() );
            }
        });
        
        vslider.valueProperty().addListener( new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    MainFactory.world.setGravity((float)hslider.getValue(), new_val.floatValue() );
            }
        });
        hslider.setTranslateX(AppConstants.WALL_WIDTH - 210);
        hslider.setTranslateY(AppConstants.WALL_WIDTH + 6);
        vslider.setTranslateX(AppConstants.WALL_WIDTH - 610);
        vslider.setTranslateY(AppConstants.WALL_WIDTH + 6);        
        //content.add(hslider);
        //content.add(vslider);         <------------ remove comments to reinitiate
        
        
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        
        /***************************/
        /********** ~~~~ ***********/
        /***************************/
        
        //Button
        Button btRestore = new Button("Restore Gravity");
        btRestore.setTranslateX(AppConstants.WALL_WIDTH - 400);
        btRestore.setTranslateY(AppConstants.WALL_WIDTH + 5);
        btRestore.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                hslider.setValue(AppConstants.WORLD_GRAVITY_X);
                vslider.setValue(AppConstants.WORLD_GRAVITY_Y);
                MainFactory.world.setGravity(AppConstants.WORLD_GRAVITY_X, AppConstants.WORLD_GRAVITY_Y);
            }
        });
        //content.add(btRestore);        <--------------
        
        /***************************/
        /***************************/
        /***************************/
        
        
        
        /***************************/
        /******IN GAME BUTTONS******/
        /***************************/
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(menu, pause, restart);
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.setPadding(new Insets(693, 10, 10, 10));
        hbox.setSpacing(10);
        
        content.add(hbox);
        /***************************/
        /***************************/
        /***************************/
        
        
        
        MainFactory.createAll();//initiate shape(body Phys2D) creation
        
        
        
        
        
        
        /***************************/
        /****** MISC SHAPES ********/ //including main bar and controller
        /***************************/
        
        b0 = SquaresFactory.createBar(349, -50);
        //b2 = SquaresFactory.createBar2(349, -50);
        b1 = SquaresFactory.createMouseSquare(349, 500);
        
        b1.setOnMouseDragged(new EventHandler<MouseEvent>() {
                            
                            @Override
                            public void handle(MouseEvent e) {
                                //b1.getBody().adjustVelocity(new Vector2f(0, 1));
                                //System.out.println(b1.getBody().getVelocity());
                                b1.getBody().setPosition((float)e.getX(), (float)e.getY());
                                //System.out.println(e.getX()+", "+e.getY());
                                
                            }
                        });
        
        
        content.addAll(b0, labelScore);
        
        /***************************/
        /***************************/
        /***************************/
        
        
        
        
        
        /*********************************************************************/
        /*********************************************************************/
        /********************       GAME LOOP     ****************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/

        
        play.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                reset();
                everySecond2.stop();
                Timeline delayTimeline = new Timeline();
                final int millis = 14;//updates ever 14 ms
                delayTimeline.getKeyFrames().add(
                        new KeyFrame(new Duration(millis - (System.currentTimeMillis() % millis)), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        final Timeline everySecond = new Timeline();
                        everySecond.setCycleCount(Timeline.INDEFINITE);//keeps on running until user shuts down
                        everySecond.getKeyFrames().add(
                                new KeyFrame(Duration.valueOf(millis+"ms"), new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {
                                
                                timer+=14;
                                labelScore.setText("Score: "+score);
                                if(timer / (2*counter) >= 1000 && timer / (2*counter) <= 1500){
                                    int tempScore = score;
                                    
                                    addScore();
                                    counter++;
                                    
                                    if(score < 20){
                                        if(tempScore - score < 0) {
                                            verified= "✓";
                                        }
                                    }
                                }
                                
                                if(timer / (2*counter2) >= 5000 && timer / (2*counter2) <= 5500){
                                    addCircle();
                                    counter2++;
                                }
                                
                                if(timer / (2*counter3) >= 8000 && timer / (2*counter3) <= 8500){
                                    addSquare();
                                    counter3++;
                                }
                              
                                
                                if(collided == true){
                                    
                                    final Stage dialogStage = new Stage();
                                    Scene scene = new Scene(new Group(), 200, 200, Color.WHITE);
                                    /*(VBoxBuilder.create().
                                        children(new Text("Hi"), menu, restart).
                                        alignment(Pos.CENTER).padding(new Insets(5)).build(), 200, 200, Color.web("#F5F5F5"));*/
                                    
                                    content3 = ((Group) scene.getRoot()).getChildren();
                                    VBox vbox = new VBox();
                                    
                                    String status = "";
                                    if(score > 100 && score < 150){
                                        status = "Not bad, okay...";
                                    }else if(score > 150 && score < 250){
                                        status = "Nice, lol";
                                    }else if(score > 250 && score < 350){
                                        status = "Holy Crap, get a life.";
                                    }else if(score > 350){
                                        status = "Jesus.";
                                    }else status = "You really suck.";
                                        
                                    
                                    vbox.getChildren().addAll(new Text(status), new Text(verified+" Score: "+score), menu2, restart2);
                                    vbox.setAlignment(Pos.CENTER);
                                    vbox.setPadding(new Insets(35, 5, 5, 50));
                                    vbox.setSpacing(20);
                                    
                                    final Canvas canvas = new Canvas(200,200);
                                    final GraphicsContext gc = canvas.getGraphicsContext2D();
                                    Image bgd = new Image(getClass().getResourceAsStream("res/bgd.png"));
                                    gc.drawImage(bgd, (double)0, (double)0, (double)200, (double)200);
                                    
                                    content3.addAll(canvas, vbox);
                                    
                                    dialogStage.initModality(Modality.WINDOW_MODAL);
                                    
                                    dialogStage.setScene(scene);
                                    dialogStage.show();
                                    everySecond.stop();
                                    
                                    menu2.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(scene2);
                                        
                                        everySecond2.play();
                                        dialogStage.hide();
                                        
                                        collided = false;
                                        
                                     }
                                    });
                                    
                                    restart2.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        reset();
                                        everySecond.play();
                                        dialogStage.hide();
                                        
                                        collided = false;
                                        
                                     }
                                    });
                                    
                                    
                                }



                                MainFactory.updateAll();
                                MainFactory.doStep();
                                
                                
                                
                                
                                 menu.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(scene2);
                                        everySecond.stop();
                                        everySecond2.play();
                                        
                                        collided = false;
                                        
                                     }
                                    });
                                 
                                 pause.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        everySecond.pause();
                                        pause.setText("Unpause");
                                        pause.setOnAction(new EventHandler<ActionEvent>() {
                                            public void handle(ActionEvent event) {
                                                    pause.setText("Pause");
                                                    everySecond.play();
                                        
                                                }
                                               });
                                        
                                     }
                                    });
                                 
                                 restart.setOnAction(new EventHandler<ActionEvent>() {
                                    public void handle(ActionEvent event) {
                                        reset();
                                        
                                     }
                                    });

                            }

                        }));

                        everySecond.play();

                    }
                }));

                delayTimeline.play();
                
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            
        });
        
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        
        
        
        
        
        
        
        
        /*********************************************************************/
        /*********************************************************************/
        /******************     MENU FUN AND STUFF       *********************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        
        
        content2.addAll(canvasMenu);
        
        ArrayList<CircleBody> arrCircles = CirclesFactory.createCircles2(10);
        for(int i = 0; i < arrCircles.size(); i++){
            content2.add(arrCircles.get(i));
        }
        
        ArrayList<SquareBody> arrSquares = SquaresFactory.createSquares2(10);
        for(int i = 0; i < arrSquares.size(); i++){
            content2.add(arrSquares.get(i));
        }
        
        content2.addAll(play, htp, cred);
        
        Timeline delayTimeline = new Timeline();
                final int millis = 14;//updates ever 14 ms
                delayTimeline.getKeyFrames().add(
                        new KeyFrame(new Duration(millis - (System.currentTimeMillis() % millis)), new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        everySecond2.setCycleCount(Timeline.INDEFINITE);//keeps on running until user shuts down
                        everySecond2.getKeyFrames().add(
                                new KeyFrame(Duration.valueOf(millis+"ms"), new EventHandler<ActionEvent>() {

                            @Override
                            public void handle(ActionEvent event) {

                                MainFactory.updateMenu();
                                MainFactory.doMenuStep();

                            }

                        }));

                        everySecond2.play();

                    }
                }));

                delayTimeline.play();
                
                primaryStage.setScene(scene2);//menu
                primaryStage.show();
                
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
        /*********************************************************************/
                
            
    }

    public void reset(){
        //b0.getBody().
        score = 0;
        b0.getBody().setRotation(0);
        b0.getBody().setPosition(349, -50);
        b1.getBody().setPosition(349, 500);
        
    }
    
    
    public void writeScore(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("score.txt", "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        writer.println("1000");
        writer.close();
        
    }
    
    
    public void readScore(){
        try {
            // Create a URL for the desired page
            URL url = new URL("http://www.icypixel.net/projects/icybalance/score.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch (IOException e) {
        }
    }
    
    public void addScore(){
         score+=10;
    }
    
    public void addCircle(){
        
         content.add(CirclesFactory.createCircles().get(0));
         
    }
    
    public void addSquare(){
        
         content.add(SquaresFactory.createSquares().get(0));
         
    }
    
    public Application getApp(){
        return this;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }    
}
