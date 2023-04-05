/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goosegame;

import java.util.Scanner;


public class Game {
    private Board board;
    private Player players[];
    private Dices dices;
    private int numberOfPlayers;

    public Game() {
        board = new Board();
        dices = new Dices();
    }
    
    public void init(){
        
        getPlayersInfo();
        
        createBoard();
        
        Square firstSquare = board.getSquare(0);
        
        for (Player p: players){
            p.moveTo(firstSquare);
        }
    }
    
    
    private void createBoard(){
        board.addSquare(new InitialSquare(board, players));
        board.addSquare(new Square(board, 1));
        board.addSquare(new Square(board, 2));
        board.addSquare(new Square(board, 3));
        board.addSquare(new Square(board, 4));
        board.addSquare(new GooseSquare(board, 5, dices));
        board.addSquare(new BridgeSquare(12, board, 6)); 
        board.addSquare(new Square(board, 7));
        board.addSquare(new Square(board, 8));
        board.addSquare(new GooseSquare(board, 9, dices));
        board.addSquare(new Square(board, 10));
        board.addSquare(new Square(board, 11));
        board.addSquare(new Square(board, 12));
        board.addSquare(new Square(board, 13));
        board.addSquare(new GooseSquare(board, 14, dices));
        board.addSquare(new Square(board, 15));
        board.addSquare(new Square(board, 16));
        board.addSquare(new Square(board, 17));
        board.addSquare(new Square(board, 18));
        board.addSquare(new InnSquare(2, board, 19));
        board.addSquare(new Square(board, 20));
        board.addSquare(new Square(board, 21));
        board.addSquare(new Square(board, 22));
        board.addSquare(new GooseSquare(board, 23, dices));
        board.addSquare(new Square(board, 24));
        board.addSquare(new Square(board, 25));
        board.addSquare(new Square(board, 26));
        board.addSquare(new GooseSquare(board, 27, dices));
        board.addSquare(new Square(board, 28));
        board.addSquare(new Square(board, 29));
        board.addSquare(new Square(board, 30));
        board.addSquare(new WellSquare(board, 31));
        board.addSquare(new GooseSquare(board, 32, dices));
        board.addSquare(new Square(board, 33));
        board.addSquare(new Square(board, 34));
        board.addSquare(new Square(board, 35));
        board.addSquare(new GooseSquare(board, 36, dices));
        board.addSquare(new Square(board, 37));
        board.addSquare(new Square(board, 38));
        board.addSquare(new Square(board, 39));
        board.addSquare(new Square(board, 40));
        board.addSquare(new GooseSquare(board, 41, dices));
        
        Square s = board.getSquare(30);
        board.addSquare(new ReturnSquare("Labyrinth", s, board, 42));
        
        
        board.addSquare(new Square(board, 43));
        board.addSquare(new Square(board, 44));        
        board.addSquare(new GooseSquare(board, 45, dices));        
        board.addSquare(new Square(board, 46));
        board.addSquare(new Square(board, 47));
        board.addSquare(new Square(board, 48));
        board.addSquare(new Square(board, 49));
        board.addSquare(new GooseSquare(board, 50, dices));
        board.addSquare(new Square(board, 51));
        board.addSquare(new Square(board, 52));
        board.addSquare(new Square(board, 53));
        board.addSquare(new GooseSquare(board, 54, dices));
        board.addSquare(new Square(board, 55));
        board.addSquare(new Square(board, 56));
        board.addSquare(new Square(board, 57));
        
        s = board.getSquare(1);
        board.addSquare(new ReturnSquare("Death", s, board, 58));
        
        //board.addSquare(new GooseSquare(board, 59, dices));
        board.addSquare(new Square(board, 59));
        board.addSquare(new Square(board, 60));
        board.addSquare(new Square(board, 61));
        board.addSquare(new Square(board, 62));
        board.addSquare(new LastSquare(board, 63));
    }
    
    private void getPlayersInfo(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of players 2 - 6");
        int p = scanner.nextInt();
        
        while (p < 2 || p > 6){
            System.out.println("Wrong number of players, try again... (2 - 6)");
            p = scanner.nextInt();
        }
        
        numberOfPlayers = p;
        
        players = new Player[numberOfPlayers];
        
        for (int i = 0 ; i < numberOfPlayers ; i++){
            System.out.println("Enter name of player number " + (i + 1));
            String name = scanner.next();
            
            players[i] = new Player(name, board);
        }
    }
    
    public void play(){
        String playerName;
        int winners = 0;
        int wellers = 0;
        Player p;

        
        while (winners + wellers < numberOfPlayers){
            wellers = 0;
            
            for (int i = 0 ; i < players.length ; i++){
                p = players[i];
                if (p == null) System.out.println("error");
                playerName = p.getName();

                if (p.isWinner()) {
                    System.out.println("\nPlayer " + playerName + " is a winner!\n");
                }
                else if (p.isInWell()){
                    wellers++;
                    System.out.println("\nPlayer " + playerName + " is in well!\n");
                }
                else if (p.missesRound()){
                    System.out.println("\nPlayer " + playerName + " misses round!\n");
                    p.decreaseMissedRounds();
                }
                else {
                    p.play(dices);
                    if (p.isWinner()) winners++;
                }
            }
            System.out.println("---");
        }
    }
}
