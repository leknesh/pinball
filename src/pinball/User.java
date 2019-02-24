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
public class User implements java.io.Serializable {

    public String name;
    public int score;
    
    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    public void setScore(int points) {
        score += points;
    }
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "User: " + getName() + "    Score: " + getScore(); 
    }
    
}
