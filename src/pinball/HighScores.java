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
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henriette
 */
public class HighScores extends ArrayList<User> {
    ArrayList<User> highScores;
    private final String FILENAME = "highscore.jar"; 
    private FileInputStream fileIn = new FileInputStream(FILENAME);            
    private ObjectInputStream input = new ObjectInputStream(fileIn);
    private FileOutputStream fileOut = new FileOutputStream(FILENAME);            
    private ObjectOutputStream output = new ObjectOutputStream(fileOut);
    
    
    public HighScores() throws IOException, ClassNotFoundException{
        this.highScores = getHighScores();
    }  
    
    public ArrayList<User> getHighScores() throws IOException, ClassNotFoundException {
        try {
            while (input.available() > 0){
                    highScores = (ArrayList<User>) input.readObject();
            }
            if (highScores.size() > 0){
                Collections.sort(highScores);
            }
        }
        catch (IOException ex){
            Logger.getLogger(Pinball.class.getName()).log(Level.SEVERE, null, ex);
        }
        return highScores;
    }
    
    public void newScore(User user) throws IOException, ClassNotFoundException {
        this.add(user);
        Collections.sort(this);
        //removing lowest score if not in top10. 
        //List will never be > 11 at this point
        if (this.size() > 10){
            this.remove(11);
        }
    }
    
    //writing a new score to highscorelist
    public void writeHighScore() throws IOException, ClassNotFoundException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILENAME))
                ){
            output.writeObject(this); 
            
        } 
    } 
}
