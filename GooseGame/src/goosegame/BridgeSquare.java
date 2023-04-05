/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

public class BridgeSquare extends Square{
    private int squareDestination;

    public BridgeSquare(int squareDestination, Board board, int number) {
        super(board, number);
        this.squareDestination = squareDestination;
    }
    
    public void action(){
        Board board = getBoard();
        Player player = getPlayer();
        Square newSquare = board.getSquare(squareDestination);
        
        System.out.println("Player " + player.getName() + 
                " is on a bridge square, so he advances to square " + 
                newSquare.getNumber());
        
        player.moveTo(newSquare);     
    }
}
