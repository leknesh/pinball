
package pinball;

import javafx.scene.shape.Line;

/*
 * 
 * author: Gunnar Giil
 *
 * This class defines a construcor method for Line1 which extends Line. 
 * The class ipmlemetns a method that calculates and retruns the normal vector to a line. 
 *
 */

public class Line1 extends Line {

    // Constructor method
    public Line1(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
    }

    // Method that calculates and returns normal vector as a double[]
    public double[] getNormalVector() {
        double deltaX = getEndX()-getStartX();
        double deltaY = getEndY()-getStartY();
        double nVect[] = {deltaY, -deltaX};
        
        return nVect;
    }
}
