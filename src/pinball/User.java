/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pinball;

import java.io.Serializable;

/**
 *
 * @author Giil
 */
public class User implements Serializable, Comparable<User> {

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

    @Override
    public int compareTo(User u) {
        if (getScore() > u.getScore()){
            return 1;
        }
        else if (getScore() < u.getScore()){
            return -1;
        }
        else {
            return 0;
        }
    }  
}
