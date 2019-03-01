
package pinball;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
 * author: Gunnar Giil
 *
 * This class extends Circle and defines a constructor method for Ball. 
 * At this moment the class does not implement functionality not covered by Circle... 
 *
 */

public class Ball extends Circle {
    
    // Constructor method
    public Ball(double centerX, double centerY, double radius, Color fill) {
        super(centerX, centerY, radius, fill);
    }
    
}
