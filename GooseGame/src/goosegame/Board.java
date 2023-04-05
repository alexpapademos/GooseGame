/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.ArrayList;


public class Board {
    private ArrayList<Square> squares;
    
    
    public Board(){
        squares = new ArrayList();
    }
    
    public void addSquare(Square square){
        squares.add(square);
    }
    
    public Square getSquare(int squareNumber){
        if (squareNumber < 0){
            return null;
        }
        if (squareNumber < squares.size()){
            return squares.get(squareNumber);
        }
        
        
        squareNumber = squares.size() - (squareNumber - squares.size() + 2);
     
        
        return squares.get(squareNumber);
    }
}
