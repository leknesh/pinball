/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinball;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henriette
 */
public class HighScores extends ArrayList<User> implements Serializable {
    ArrayList<User> highScores;
    
    
    public HighScores(){};
    
    public HighScores(ArrayList<User> highScores) {
        this.highScores = highScores;
    }
    
    public void setHighScores(ArrayList<User> highScores) {
        this.highScores = highScores;
    } 
    
    public ArrayList<User> readHighScores() throws IOException, ClassNotFoundException {
        final String FILENAME = "highscore.ser"; 
        FileInputStream fileIn = new FileInputStream(FILENAME);            
        ObjectInputStream input = new ObjectInputStream(fileIn);
        
        highScores = new ArrayList<>();
        try {
            while (input.available() > 0){
                highScores = (ArrayList<User>)input.readObject();
            }
            /*if (highScores.size() > 0){
                Collections.sort(highScores);
            }*/
            }
            catch (IOException ex){
                Logger.getLogger(Pinball.class.getName()).log(Level.SEVERE, null, ex);
            }
        return highScores;
    }    
    
    //writing a new score to highscorelist
    public void writeHighScore() throws IOException, ClassNotFoundException {
        final String FILENAME = "highscore.ser"; 
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILENAME))
                ){
            output.writeObject(this);    
        } 
    } 
}
