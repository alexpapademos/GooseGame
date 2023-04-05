/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

public class InnSquare extends Square{
    private int numberOfRoundsTomiss;

    public InnSquare(int numberOfRoundsTomiss, Board board, int number) {
        super(board, number);
        this.numberOfRoundsTomiss = numberOfRoundsTomiss;
    }
    
    public void action(){
        Player player = getPlayer();
        
        System.out.println("Player " + player.getName() + 
                " is on a Inn square, so he misses " + 
                numberOfRoundsTomiss + " rounds!");
        
        // θέτω αριθμό γύρων που θα χάσει ο παίκτης
        player.setMissRounds(numberOfRoundsTomiss);
    }
}
