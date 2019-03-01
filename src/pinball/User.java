
package pinball;

import java.io.Serializable;

/*
 * authors: Gunnar Giil, Henriette Leknes
 *
 * This class defines a cunstructor method for User, and contains set- and get-methods for username and score. 
 *
 */

public class User implements Serializable, Comparable<User> {

    // Initializing variables
    public String name;
    public int score;
    
    // Constructor method
    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    // method that sets score
    public void setScore(int points) {
        score += points;
    }
    
    // method to get score
    // return score as an integer. 
    public int getScore() {
        return score;
    }
    
    // method to get username
    // returns username as a string
    public String getName() {
        return name;
    }
    
    // toString method
    // returning a string containing username and score
    // Not used in the game in this version(!)
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
