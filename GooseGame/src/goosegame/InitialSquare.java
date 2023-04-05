/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;
public class InitialSquare extends Square{
    private Player players[];
    
    public InitialSquare(Board board, Player players[]) {
        super(board, 0);
        this.players = players;
    }
    
    
    
}
