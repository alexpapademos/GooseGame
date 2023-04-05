/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;
public class Player {
    private final String name;
    private final Board board;
    private Square square;
    private int missRounds;
    private boolean inWell;
    private boolean winner;
    private int round;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        round = 0;
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }
    
    public void moveTo(Square newsquare){
        // αν βρίσκομαι ήδη σε κάποιο τετράγωνο
        if (this.square != null){
            // διαγράφω το τετράγωνο που ήμουν
            this.square.setPlayer(null);
            
            // αν το νεο τετράγωνο έχει άλλον μέσα
            if (newsquare.isEmpty() == false){
                // κρατάω αυτόνπου θα διώξω
                Player otherPlayer = newsquare.getPlayer();
                
                
                System.out.println("Player " + otherPlayer.getName() + 
                        " was on the same square, so he returned to square " + square.getNumber());
                
                // ο άλλος παικτης έρχεται στο δικό μου τετράγωνο
                otherPlayer.moveTo(this.square);
            }
        }
        
        
        // πλέον βρίσκομαι στο νέο τετράγωνο
        this.square = newsquare;
        this.square.setPlayer(this);
        
        System.out.println("Now player " + name + " is on square " + newsquare.getNumber());
        
        square.action();
    }
    
    public int getSquareNumber(){
        return square.getNumber();
    }
    
    public void setMissRounds(int missRounds){
        this.missRounds = missRounds;
    }
    
    public void setInWell(boolean isInWell){
        inWell = isInWell;
    }
    
    public void setWinner(){
        winner = true;
    }
    
    public boolean isWinner(){
        return winner;
    }
    
    public boolean isInWell(){
        return inWell;
    }
    
    public boolean missesRound(){
        if (missRounds == 0) return false;
        return true;
    }
    
    public void decreaseMissedRounds(){
        missRounds--;
    }
    
    public void play(Dices dices){
        Square newSquare;
        
        dices.roll_dices();
        
        System.out.println("\nPlayer " + name + " is on square " + square.getNumber() +
                " and roll the dice getting " + dices.getFirstDice() + " and " +
                dices.getSecondDice());
        
        // για τον πρώτο γύρο ισχύει το 6+3 ή 5+4
        if (round == 0 && dices.is6and3()){
            newSquare = board.getSquare(26);
        }
        else if (round == 0 && dices.is5and4()){
            newSquare = board.getSquare(53);
        }
        else {
            newSquare = board.getSquare(square.getNumber() + dices.getSumDices());
        }
        round++;
        
        moveTo(newSquare);
    }
}
