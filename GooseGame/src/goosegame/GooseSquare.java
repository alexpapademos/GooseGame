/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

public class GooseSquare extends Square{
    private Dices dices;

    public GooseSquare(Board board, int number, Dices dices) {
        super(board, number);
        this.dices = dices;
    }
    
    
    public void action(){
        Board board = getBoard();
        Player player = getPlayer();
        int sumDices = dices.getSumDices();
        int squareNumber = player.getSquareNumber();
        
        // βρίσκω που πρέπει να πάω με την ίδια ζαριά
        Square newSquare = board.getSquare(squareNumber + sumDices);
        
        System.out.println("Player " + player.getName() + 
                " is on a goose square, so he flies to square " + 
                newSquare.getNumber());
        
        // μετακινώ τον παίκτη στη νέα θέση
        player.moveTo(newSquare);        
    }
}
