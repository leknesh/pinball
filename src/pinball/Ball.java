/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Giil
 */

// Ball and animation variable declarations



public class Ball extends Circle {
    
    public double radius;
    public double x , y ;
    public Ball(double centerX, double centerY, double radius, Color fill) {
        super(centerX, centerY, radius, fill);
    }
    
}
