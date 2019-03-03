
package pinball;

import java.io.Serializable;

/*
 * authors: Gunnar Giil, Henriette Leknes
 *
 * This class defines a cunstructor method for User, and contains set- and 
get-methods for username and score. A string can be built in the toString-method, 
and a compareTo-method enables an arraylist of users to be sorted according to 
score using the Comparable-interface. The class also implements serializable to enable 
saving of user objects to file.
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
    @Override
    public String toString() {
        String string = getName();
        //adding a number of spaces to name length to increase readability
        for (int i = getName().length(); i<20; i++){
            string += " ";
        }
        string += getScore() + " "; 
        return string;
    }

    // compareTo-method
    // enables an arraylist of users to be sorted based on game score.
    // requires Comparable interface
    @Override
    public int compareTo(User u) {
        if (getScore() > u.getScore()){
            return -1;
        }
        else if (getScore() < u.getScore()){
            return 1;
        }
        else {
            return 0;
        }
    }  
}
