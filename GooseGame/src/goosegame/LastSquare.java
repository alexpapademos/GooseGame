/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

public class LastSquare extends Square{

    public LastSquare(Board board, int number) {
        super(board, number);
    }
    
    public void action(){
        Player player = getPlayer();
        
        
        System.out.println("Player " + player.getName() + 
                " is on last square, so he WINS!!! ");
        
        player.setWinner();
        setPlayer(null);
    }
}
