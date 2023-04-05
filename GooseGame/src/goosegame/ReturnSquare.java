/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

public class ReturnSquare extends Square{
    private final String squareName;
    private final Square returnToSquare;

    public ReturnSquare(String squareName, Square returnToSquare, Board board, int number) {
        super(board, number);
        this.squareName = squareName;
        this.returnToSquare = returnToSquare;
    }
    
    public void action(){
        
        Player player = getPlayer();
        
        
        System.out.println("Player " + player.getName() + 
                " is on a " + squareName + " square, so he returns to square " + 
                returnToSquare.getNumber());
        
        player.moveTo(returnToSquare);     
    }
}
