/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinball;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Giil
 * 
 * This class creates objects defining the borders and obstacles of the pinball game
 * 
 */
public class PinballLayout {
    
    double nAngle;
    
    public void getLayout(Group objects, Group lines, Group circles, Group arcs, Group rectangles) {
        
        Line1 lStart1 = new Line1(480, 600, 480, 110);
        lStart1.setStroke(Color.BLACK);
        objects.getChildren().add(lStart1);
        lines.getChildren().add(lStart1);
        
        Line1 lStart2 = new Line1(450, 600, 450, 150);
        lStart2.setStroke(Color.BLACK);
        objects.getChildren().add(lStart2);
        lines.getChildren().add(lStart2);
        
        Line1 lTopRight = new Line1(480, 110, 405, 35);
        lTopRight.setStroke(Color.BLACK);
        objects.getChildren().add(lTopRight);
        lines.getChildren().add(lTopRight);
        
        Line1 lTop = new Line1(405, 35, 100, 35);
        lTop.setStroke(Color.BLACK);
        objects.getChildren().add(lTop);
        lines.getChildren().add(lTop);
        
        Line1 lTopLeft1 = new Line1(100, 35, 40, 151);
        lTopLeft1.setStroke(Color.BLACK);
        objects.getChildren().add(lTopLeft1);
        lines.getChildren().add(lTopLeft1);
       
        Line1 lTopLeft2 = new Line1(78, 80, 155, 250);
        lTopLeft2.setStroke(Color.BLACK);
        objects.getChildren().add(lTopLeft2);
        lines.getChildren().add(lTopLeft2);
         
        Line1 lLeft1 = new Line1(40, 151, 55, 269);
        lLeft1.setStroke(Color.BLACK);
        objects.getChildren().add(lLeft1);
        lines.getChildren().add(lLeft1);
        
        Line1 lLeft2 = new Line1(55, 269, 90, 315);
        lLeft2.setStroke(Color.BLACK);
        objects.getChildren().add(lLeft2);
        lines.getChildren().add(lLeft2);
      
        Line1 lLeft3 = new Line1(90, 315, 40, 360);
        lLeft3.setStroke(Color.BLACK);
        objects.getChildren().add(lLeft3);
        lines.getChildren().add(lLeft3);
   
        Line1 lLeft4 = new Line1(40, 360, 40, 468);
        lLeft4.setStroke(Color.BLACK);
        objects.getChildren().add(lLeft4);
        lines.getChildren().add(lLeft4);
        
        Line1 lBottimLeft = new Line1(40, 468, 190, 540);
        lBottimLeft.setStroke(Color.BLACK);
        objects.getChildren().add(lBottimLeft);
        lines.getChildren().add(lBottimLeft);
        
        Line1 lBottimRight = new Line1(300, 540, 450, 468);
        lBottimRight.setStroke(Color.BLACK);
        objects.getChildren().add(lBottimRight);
        lines.getChildren().add(lBottimRight);
        
        Arc arcBottom = new Arc(245, 521, 71, 30, 220, 100);
        arcBottom.setType(ArcType.OPEN);
        arcBottom.setFill(null);
        arcBottom.setStroke(Color.BLACK);
        objects.getChildren().add(arcBottom);
        arcs.getChildren().add(arcBottom);
        
        Line1 lFlipperRight1 = new Line1(410, 440, 410, 380);
        lFlipperRight1.setStroke(Color.BLACK);
        objects.getChildren().add(lFlipperRight1);
        lines.getChildren().add(lFlipperRight1);
            
        Line1 lFlipperRight2 = new Line1(320, 477, 410, 440);
        lFlipperRight2.setStroke(Color.BLACK);
        objects.getChildren().add(lFlipperRight2);
        lines.getChildren().add(lFlipperRight2);
        
        Line1 lFlipperLeft1 = new Line1(80, 440, 80, 380);
        lFlipperLeft1.setStroke(Color.BLACK);
        objects.getChildren().add(lFlipperLeft1);
        lines.getChildren().add(lFlipperLeft1);
        
        Line1 lFlipperLeft2 = new Line1(80, 440, 170, 477);
        lFlipperLeft2.setStroke(Color.BLACK);
        objects.getChildren().add(lFlipperLeft2);
        lines.getChildren().add(lFlipperLeft2);
        
        Line1 lTriangleLeft1 = new Line1(122, 370, 122, 410);
        lTriangleLeft1.setStroke(Color.BLACK);
        objects.getChildren().add(lTriangleLeft1);
        lines.getChildren().add(lTriangleLeft1);
       
        Line1 lTriangleLeft2 = new Line1(165, 430, 122, 410);
        lTriangleLeft2.setStroke(Color.BLACK);
        objects.getChildren().add(lTriangleLeft2);
        lines.getChildren().add(lTriangleLeft2);
         
        Line1 lTriangleLeft3 = new Line1(122, 370, 165, 430);
        lTriangleLeft3.setStroke(Color.BLACK);
        objects.getChildren().add(lTriangleLeft3);
        lines.getChildren().add(lTriangleLeft3);
        
        Line1 lTriangleRight1 = new Line1(366, 410, 366, 370);
        lTriangleRight1.setStroke(Color.BLACK);
        objects.getChildren().add(lTriangleRight1);
        lines.getChildren().add(lTriangleRight1);
        
        Line1 lTriangleRight2 = new Line1(366, 410, 323, 430);
        lTriangleRight2.setStroke(Color.BLACK);
        objects.getChildren().add(lTriangleRight2);
        lines.getChildren().add(lTriangleRight2);
        
        Line1 lTriangleRight3 = new Line1(323, 430, 366, 370);
        lTriangleRight3.setStroke(Color.BLACK);
        objects.getChildren().add(lTriangleRight3);
        lines.getChildren().add(lTriangleRight3);      
        
        Line1 lTopRight1 = new Line1(450, 150, 380, 240);
        lTopRight1.setStroke(Color.BLACK);
        objects.getChildren().add(lTopRight1);
        lines.getChildren().add(lTopRight1);
        
        Line1 lTopRight2 = new Line1(450, 330, 380, 240);
        lTopRight2.setStroke(Color.BLACK);
        objects.getChildren().add(lTopRight2);
        lines.getChildren().add(lTopRight2);
        
        Circle sTop1 = new Circle(260, 100, 20);
        sTop1.setStroke(Color.BLACK);
        sTop1.setFill(Color.RED);
        objects.getChildren().add(sTop1);
        circles.getChildren().add(sTop1);
        
        Circle sTop2 = new Circle(300, 140, 20);
        sTop2.setStroke(Color.BLACK);
        sTop2.setFill(Color.YELLOW);
        objects.getChildren().add(sTop2);
        circles.getChildren().add(sTop2);
        
        Circle sTopLEft = new Circle(158, 256, 5);
        sTopLEft.setStroke(Color.BLACK);
        sTopLEft.setFill(Color.PURPLE);
        objects.getChildren().add(sTopLEft);
        circles.getChildren().add(sTopLEft);
        
        Circle sTop3 = new Circle(220, 140, 20);
        sTop3.setStroke(Color.BLACK);
        sTop3.setFill(Color.YELLOW);
        objects.getChildren().add(sTop3);
        circles.getChildren().add(sTop3);
        
        Circle sLeft = new Circle(70, 140, 20);
        sLeft.setStroke(Color.BLACK);
        sLeft.setFill(Color.PURPLE);
        objects.getChildren().add(sLeft);
        circles.getChildren().add(sLeft);
        
        Line1 lFlipperLeft3 = new Line1(170, 477, 225, 490);
        lFlipperLeft3.setStroke(Color.BLACK);
        objects.getChildren().add(lFlipperLeft3);
        lines.getChildren().add(lFlipperLeft3);
        
        Line1 lFlipperRight3 = new Line1(265, 490, 320, 477);
        lFlipperRight3.setStroke(Color.BLACK);
        objects.getChildren().add(lFlipperRight3);
        lines.getChildren().add(lFlipperRight3);
        
        Line1 lStartLine1 = new Line1(450, 487, 457, 487);
        lStartLine1.setStroke(Color.BLACK);
        objects.getChildren().add(lStartLine1);
        lines.getChildren().add(lStartLine1);
        
        Line1 lStartLine2 = new Line1(473, 487, 480, 487);
        lStartLine2.setStroke(Color.BLACK);
        objects.getChildren().add(lStartLine2);
        lines.getChildren().add(lStartLine2);
        
        Rectangle launchRect = new Rectangle(459, 487, 12, 20);
        launchRect.setStroke(Color.BLACK);
        launchRect.setFill(Color.BLACK);
        objects.getChildren().add(launchRect);
        rectangles.getChildren().add(launchRect);
        
        
        Circle sTriangleLeft1 = new Circle(122, 370, 3);
        sTriangleLeft1.setStroke(Color.BLACK);
        sTriangleLeft1.setFill(null);
        objects.getChildren().add(sTriangleLeft1);
        circles.getChildren().add(sTriangleLeft1);
        
        Circle sTriangleLeft2 = new Circle(165, 430, 3);
        sTriangleLeft2.setStroke(Color.BLACK);
        sTriangleLeft2.setFill(null);
        objects.getChildren().add(sTriangleLeft2);
        circles.getChildren().add(sTriangleLeft2);
        
        Circle sTriangleLeft3 = new Circle(122, 410, 3);
        sTriangleLeft3.setStroke(Color.BLACK);
        sTriangleLeft3.setFill(null);
        objects.getChildren().add(sTriangleLeft3);
        circles.getChildren().add(sTriangleLeft3);
        
        Circle sTriangleRight1 = new Circle(366, 370, 3);
        sTriangleRight1.setStroke(Color.BLACK);
        sTriangleRight1.setFill(null);
        objects.getChildren().add(sTriangleRight1);
        circles.getChildren().add(sTriangleRight1);
        
        Circle sTriangleRight2 = new Circle(322, 430, 3);
        sTriangleRight2.setStroke(Color.BLACK);
        sTriangleRight2.setFill(null);
        objects.getChildren().add(sTriangleRight2);
        circles.getChildren().add(sTriangleRight2);
        
        Circle sTriangleRight3 = new Circle(366, 410, 3);
        sTriangleRight3.setStroke(Color.BLACK);
        sTriangleRight3.setFill(null);
        objects.getChildren().add(sTriangleRight3);
        circles.getChildren().add(sTriangleRight3);
       
        Circle sBottomRight = new Circle(410, 440, 3);
        sBottomRight.setStroke(Color.BLACK);
        sBottomRight.setFill(null);
        objects.getChildren().add(sBottomRight);
        circles.getChildren().add(sBottomRight);
        
        Circle sBottomRight2 = new Circle(410, 379, 3);
        sBottomRight2.setStroke(Color.BLACK);
        sBottomRight2.setFill(null);
        objects.getChildren().add(sBottomRight2);
        circles.getChildren().add(sBottomRight2);
        
        Circle sBottomLeft = new Circle(80, 440, 3);
        sBottomLeft.setStroke(Color.BLACK);
        sBottomLeft.setFill(null);
        objects.getChildren().add(sBottomLeft);
        circles.getChildren().add(sBottomLeft);
        
        Circle sBottomLeft2 = new Circle(80, 379, 3);
        sBottomLeft2.setStroke(Color.BLACK);
        sBottomLeft2.setFill(null);
        objects.getChildren().add(sBottomLeft2);
        circles.getChildren().add(sBottomLeft2);
        
        Circle sTriangleRight4 = new Circle(380, 240, 3);
        sTriangleRight4.setStroke(Color.BLACK);
        sTriangleRight4.setFill(null);
        objects.getChildren().add(sTriangleRight4);
        circles.getChildren().add(sTriangleRight4);
        
        Circle sTriangleRightTop = new Circle(450, 150, 3);
        sTriangleRightTop.setStroke(Color.BLACK);
        sTriangleRightTop.setFill(null);
        objects.getChildren().add(sTriangleRightTop);
        circles.getChildren().add(sTriangleRightTop);
        
        
        
    }
    
    
    
    
    
}
