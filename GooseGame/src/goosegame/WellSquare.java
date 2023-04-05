/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.ArrayList;

public class WellSquare extends Square{
    // ποιος παίκτης είναι μέσα στο πηγάδι
    private Player welledPlayer;

    public WellSquare(Board board, int number) {
        super(board, number);
    }
    
    
    public void action(){
        Player freePlayer = null;
        
        // αν υπάρχει κάποιος μέσα στο πηγάδι
        if (welledPlayer != null){
            // τον βγάζω από το πηγάδι
            welledPlayer.setInWell(false);
            
            // και πλέον ειναι ελεύθερος
            freePlayer = welledPlayer;
        }
        
        // ο νέος παίκτης που έπεσε στο πηγάδι
        Player player = getPlayer();
        
        // τον ρατάω στο πηγάδι
        welledPlayer = player;
        welledPlayer.setInWell(true);
        
        // αυτος που ελευθερώθηκε θα μπορεί να παίξει 
        // όταν έρθει η σειρά του (μπορεί να είναι 
        // και null ο freePlayer)
        setPlayer(freePlayer);    
        
        System.out.println("Player " + welledPlayer.getName() + " has fallen in to the well!");
        if (freePlayer != null){
            System.out.println("But player " + freePlayer.getName() + " is free to go!");
        }
    }
}
