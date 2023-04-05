/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.Random;

public class Dices {
    private final static int BOUND = 6;
    
    private int d1;
    private int d2;
    private Random random;
    
    public Dices(){
        random = new Random();
    }
    
    public void roll_dices(){
        d1 = random.nextInt(BOUND) + 1;
        d2 = random.nextInt(BOUND) + 1;
    }
    
    public int getFirstDice(){
        return d1;
    }
    
    public int getSecondDice(){
        return d2;
    }
    
    public int getSumDices(){
        return d1 + d2;
    }
    
    public boolean is6and3(){
        if (d1 == 6 && d2 == 3) return true;
        return false;
    }
    
    public boolean is5and4(){
        if (d1 == 5 && d2 == 4) return true;
        return false;
    }
}
