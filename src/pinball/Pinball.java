/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinball;

import java.io.File;
import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.LEFT;
import static javafx.scene.input.KeyCode.RIGHT;
import static javafx.scene.input.KeyCode.SPACE;
import static javafx.scene.input.KeyCode.DOWN;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author Giil
 */
public class Pinball extends Application  {
    
    // Layout, pane and object-groups declarations
    private PinballLayout pLayout = new PinballLayout();
    private Pane pinballGame = new Pane();
    private Group objects = new Group();
    private Group lines = new Group();
    private Group circles = new Group();
    private Group arcs = new Group();
    private Group rectangles = new Group();
        
    // width and height of scene
    private final int WIDTH = 500;
    private final int HEIGHT = 700;
    
    // Ball count and limitation
    private int count = 1;
    private final int MAX_COUNT = 3;
    
    // Ball start values
    private double BALL_RADIUS = 11;
    private double BALL_START_X = 465;
    private double BALL_START_Y = 475;
    private double BALL_START_DX = 0;
    private double BALL_START_DY;
    
    // Ball and animation variable declarations
    public double radius;
    private double x , y ;
    private double dx, dy;
    
    // Declaration of normal vector to line (both stationary and flippers)
    double normVect[];
    
    // Point counter
    int points;
     
    // User and score info
    private Text instructions = new Text("Press SPACE to start!");
    private Text userAndScore = new Text();
    private String leaderBoardString = "";
    private Text leaderBoardTxt = new Text(); 
    Text TOPTEN_HEADER = new Text("Pinball Wall of Fame");
    HighScores highScores;
    VBox highScoreBox;
    
    // Declare scene and user
    Scene scene;
    User u = null;
    
    // Declare ball, animation and pathTransition
    public Ball pBall;
    private Timeline animation;
    public PathTransition ptLaunch; 
    
    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
       
        BorderPane pane = new BorderPane();
        
        pLayout.getLayout(objects, lines, circles, arcs, rectangles);
        pinballGame.getChildren().addAll(objects, lines, circles, arcs, rectangles);
        
        VBox info = new VBox();
        info.getChildren().addAll(userAndScore);
        info.setPrefHeight(90);
        info.setStyle("-fx-background-color: #989ba0");
        
        //building highscore sidepane
        highScoreBox = new VBox();
        highScoreBox.setPrefWidth(90);
        highScoreBox.setStyle("-fx-background-color: lightgrey;" +
                         "-fx-border-style: solid inside;" +
                         "-fx-border-width: 1;" +
                         "-fx-border-radius: 5;" +
                         "-fx-border-color: blue;" );
        
        TOPTEN_HEADER.setFont(Font.font ("Verdana", FontWeight.BOLD, 15));
        TOPTEN_HEADER.setFill(Color.BLUE);
        highScoreBox.getChildren().add(TOPTEN_HEADER);
        
        //fetching topTen-arraylist and printing to string
        //highScores = new HighScores();
        String topTen = "";
        /*for (User u: highScores){
            topTen += u.toString() + "\n";
        }*/
        highScoreBox.getChildren().add(new Text(topTen));
        
        pane.setTop(instructions);
        pane.setRight(highScoreBox);
        pane.setCenter(pinballGame);
        pane.setBottom(info);
        
        
        scene = new Scene(pane, WIDTH+200, HEIGHT);
        primaryStage.setTitle("Pinball!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        // Scene key-events
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == SPACE) {
                newGame();
                /*
                if (count == 1) {
                    newGame();
                } else if (count == 2 || count == 3) {
                    startGame();
                } else if (count > MAX_COUNT) {
                    try {
                        highScores.newScore(u);
                    //automatic "catch-phrases"    
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(Pinball.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    count = 1;
                    newGame();  
                }*/
            }/*
            if (event.getCode() == LEFT || event.getCode() == RIGHT) {
                flipperMove(event.getCode());
            }*/
        });
        
        
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //newGame creates a new game and starts startGame methods
    public void newGame(){
        String userName = showInputDialog("Enter username: ");
        u = new User(userName, 0);
        points = 0;
        startGame();
    }
    
    // startGame creates new ball and starts animation
    // add check's for rounds per player
    public void startGame() {                   
        if (count > MAX_COUNT) {
            count = 1;
            newGame();
           
        } else {
            launchBall();
            count++;
        }
    }
    
    // Puts ball into pane and enables ejection
    public void launchBall() {
        // Get pinballball
        pBall = new Ball(BALL_START_X, BALL_START_Y, BALL_RADIUS, Color.GREEN);
        
        // Assign start values
        x = pBall.getCenterX();
        y = pBall.getCenterY();
        radius = pBall.getRadius();
        dx = BALL_START_DX;
        dy = BALL_START_DY;
         
        // Add ball to pane
        pinballGame.getChildren().addAll(pBall);
        
        Rectangle rect = (Rectangle) rectangles.getChildren().get(0);
        Line lineLaunch = new Line(465, 497, 465, 550);
        ptLaunch = new PathTransition();
        scene.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode() == DOWN) {
                 ptLaunch.setDuration(Duration.millis(2000));
                 ptLaunch.setPath(lineLaunch);
                 ptLaunch.setNode(rect);
                 ptLaunch.setCycleCount(1);
                 ptLaunch.setAutoReverse(false);
                 ptLaunch.play();
            }
            if (event.getCode() == LEFT || event.getCode() == RIGHT) {
                 flipperMove(event.getCode());
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            if (event.getCode() == DOWN) {
                ptLaunch.getCurrentTime();
                double durationSeconds = ptLaunch.getCurrentTime().toSeconds();
                ptLaunch.stop();
                
                BALL_START_DY = -1.02 * durationSeconds;
                if (BALL_START_DY < 0) {
                    newBall();
                }
            }
        });
    }    
    
    // newBall() initiates moveBall() with animation. 
    public void newBall() {
        dx = BALL_START_DX;
        dy = BALL_START_DY;
        
        if (dy > -1.02) {dy = -1.02;}
        
        // Initiate animation and ball movement
        animation = new Timeline( new KeyFrame(Duration.millis(2), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();  
    }
    
    // moveBall() initiates checkCollision and adds air friction and gravity. 
    // Also defines the x- and y-position of the center of the ball 
    public void moveBall() {
        checkCollision();
        
        // Adjust ball x-position (simple air resistance)
        if (dx > 0) {x += dx -= 0.00005;}
        if (dx < 0) {x += dx += 0.00005;}
        
        // Add gravity*, 0.00128 for testing purposes
        //y += dy += 0.0012; 
        y += dy += 0.00128; 
        
        // Max speed limitation! (to prevent errors and chaos...)
        if (dx > 1.02) {dx = 1.02;}
        if (dx < -1.02) {dx = -1.02;}
        // if (dy < -1.02) {dy = -1.02;}
        // if (dy > 1.02) {dy = 1.02;}
        
        if (dy < -2) {dy = -2;}
        if (dy > 1.02) {dy = 1.02;}
        
        pBall.setCenterX(x);
        pBall.setCenterY(y);
        if (pBall.getCenterX() > WIDTH || pBall.getCenterX() < 0 || pBall.getCenterY() > HEIGHT || pBall.getCenterY() < 0) {
            
            // Adding sound clip to ball out
            String outFile = "ballOut.mp3";     
            Media outSound = new Media(new File(outFile).toURI().toString());
            MediaPlayer outPlayer = new MediaPlayer(outSound);
            outPlayer.play();            
            stop();
        }
        userAndScore.setText(u.toString());
        
        System.out.println("XXXXX  : " + dx);
        System.out.println("YYYYY  : " + dy + "\n");
    }
    
    // Checks for collision between the ball and other objects
    // If collision is confirmed, new velocity vectors are generated (direction and velocities)
    public boolean checkCollision() {
        for (Node children : circles.getChildren()) {
            if (Shape.intersect( pBall, (Shape) children).getBoundsInLocal().isEmpty() == false) {
                Circle circle;
                // Adds points/score when/if ball hits circle-object
                u.setScore(points += 100);
                
                //adds hit sound clip
                String hitFile = "hit.mp3";     
                Media hitSound = new Media(new File(hitFile).toURI().toString());
                MediaPlayer hitPlayer = new MediaPlayer(hitSound);
                hitPlayer.play();
                
                for (int i = 0; i < circles.getChildren().size(); i++) {
                    circle = (Circle) circles.getChildren().get(i);
                    Circle ball = (Circle) pBall;
                    if ( children.equals(circle)) {
                        // --------   https://ericleong.me/research/circle-circle/
                        // Vector between ball center and circle center
                        double vect[] = {ball.getCenterX()-circle.getCenterX(), ball.getCenterY()-circle.getCenterY()};
                        // Length of vector "vect[]"
                        double vectLength = Math.sqrt(Math.pow(vect[0], 2) + Math.pow(vect[1], 2));
                        // Normal vector of stationary circle
                        double normVectCircle[] = {vect[0]/vectLength, vect[1]/vectLength};
                        dx = normVectCircle[0] * 0.71;
                        dy = normVectCircle[1] * 0.71;
                    }
                }
                return true;
            }
        }
        // Checking for collisions with lines
        for (Node children : lines.getChildren()) {
            if (Shape.intersect( pBall, (Shape) children).getBoundsInLocal().isEmpty() == false) {
                Line1 line;
                for (int i = 0; i < lines.getChildren().size(); i++) {
                    if ( children.equals(lines.getChildren().get(i))) {
                        
                        // --------- https://math.stackexchange.com/questions/13261/how-to-get-a-reflection-vector
                        line = (Line1) lines.getChildren().get(i);
                        
                        // Initial velocity vector ball
                        double inVect[] = {dx, dy};
                        
                        // IF line is left Flipper
                        if (line.equals(lines.getChildren().get(24))) {
                            // Getting new x- and y-variables for the transformed/animated flipper
                            Point2D transformStartXY = line.localToParent(line.getEndX(), line.getEndY());
                            double endX = transformStartXY.getX();
                            double endY = transformStartXY.getY();
                            
                            // Calculate normal vector based on the new points
                            // double vect[] = {line.getStartY()-endY, -(line.getStartX()-endX)};
                            double vect[] = {-(endY-line.getStartY()), (endX-line.getStartX())};
                            normVect = vect;
                            
                            // Calculate new velocity vector
                            double outVect[] = newVelocityVector(inVect, normVect);
                            
                            dx = outVect[0]*1;
                            dy = outVect[1]*1.06;
                            
                        // ELSE IF line is right flipper
                        } else if (line.equals(lines.getChildren().get(25))) {
                            // Getting new x- and y-variables for the transformed/animated flipper
                            Point2D transformStartXY = line.localToParent(line.getStartX(), line.getStartY());
                            double startX = transformStartXY.getX();
                            double startY = transformStartXY.getY();
                            
                            // Calculate normal vector based on the new points
                            // double vect[] = {(line.getEndY()-startY), -(line.getEndX()-startX)};
                            double vect[] = {(line.getEndY()-startY), -(line.getEndX()-startX)};
                            normVect = vect;
                            
                            // Calculate new velocity vector
                            double outVect[] = newVelocityVector(inVect, normVect);
                            
                            dx = outVect[0]*1;
                            dy = outVect[1]*1.06;
                            
                        // ELSE (if not a flipper)
                        } else { 
                            normVect = line.getNormalVector();
                            
                            // Calculate new velocity vector
                            double outVect[] = newVelocityVector(inVect, normVect);
                            
                            dx = outVect[0]*0.95;
                            dy = outVect[1]*1;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    // Calculating new velocity vectors
    // Formula used as basis for this calculation is found in documentation
    // The calculations are separated into smaller and more comprehendable steps... 
    public double[] newVelocityVector (double[] inVect, double[] normVect) {
        // Initial velocity vector times 2 (used in further calculations)
        double inVectTimes2[] = {2*inVect[0], 2*inVect[1]};
        // Length of normal vector of stationary line
        double normVectLength = Math.pow(Math.sqrt(Math.pow(normVect[0], 2) + Math.pow(normVect[1], 2)),2);
        // Steps of calculation (Read documentation to see formula)
        double step1 = inVectTimes2[0]*normVect[0] + inVectTimes2[1]*normVect[1];
        double step2 = step1/normVectLength;
        double step3[] = {step2*normVect[0], step2*normVect[1]};
        // Final velocity vector of ball after collision
        double outVect[] = {inVect[0]-step3[0], inVect[1]-step3[1]};

        return outVect;
    }
    
    public void flipperMove(KeyCode keyCode) {
        Line1 flipperLeft1 = (Line1) lines.getChildren().get(24);
        Line1 flipperRight1 = (Line1) lines.getChildren().get(25);
        
        Rotate rotationTransform = new Rotate();
        Timeline rotationAnimation = new Timeline();
        
        // Adding sound clip for flipper movement
        String flipFile = "flipper.mp3";     
        Media flipSound = new Media(new File(flipFile).toURI().toString());
        MediaPlayer flipPlayer = new MediaPlayer(flipSound);
               
        if (keyCode == LEFT) {
            flipperLeft1.getTransforms().add(rotationTransform);
            rotationTransform.setPivotX(flipperLeft1.getStartX());
            rotationTransform.setPivotY(flipperLeft1.getStartY());
            
            rotationAnimation.getKeyFrames().add(
                new KeyFrame(Duration.millis(170), 
                new KeyValue(rotationTransform.angleProperty(), -45)));
        } 
        if (keyCode == RIGHT) {
            flipperRight1.getTransforms().add(rotationTransform);
            rotationTransform.setPivotX(flipperRight1.getEndX());
            rotationTransform.setPivotY(flipperRight1.getEndY());
            
            rotationAnimation.getKeyFrames().add(
                new KeyFrame(Duration.millis(170), 
                new KeyValue(rotationTransform.angleProperty(), 45)));
        }
        rotationAnimation.setCycleCount(2);
        rotationAnimation.setAutoReverse(true);
        rotationAnimation.play();
        flipPlayer.play();
    }
    
     // stop() stops the animation if the ball hits the bottom 
    @Override
    public void stop() {
        animation.stop();
        pinballGame.getChildren().remove(pBall);
        startGame();
    }
    
}
