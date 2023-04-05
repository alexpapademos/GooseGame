/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;


public class Square {
    private final int number;
    private Player player;
    private Board board;

    public Square(Board board, int number) {
        this.number = number;
        this.board = board;
    }

    public int getNumber() {
        return number;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
     
    public void action(){
        
    }

    public Board getBoard() {
        return board;
    }
    
    public boolean isEmpty(){
        if (player == null) return true;
        return false;
    }
}
