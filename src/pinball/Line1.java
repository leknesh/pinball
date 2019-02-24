/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinball;

/**
 *
 * @author Giil
 */

import javafx.scene.shape.Line;


/**
 * @author Gunnar Giil
 */

/*
 * Line1 is a class extending Line
 * It adds a funtion to return normal vector of line-objects
*/
public class Line1 extends Line {


    public Line1(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
    }

    // Function to return the normal vector of a line 
    public double[] getNormalVector() {
        double deltaX = getEndX()-getStartX();
        double deltaY = getEndY()-getStartY();
        double nVect[] = {deltaY, -deltaX};
        
        return nVect;
    }
}
