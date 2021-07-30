package com.TicTacToe;

import java.util.Scanner;
import java.lang.InterruptedException;

public class Game{

    static Scanner scan = new Scanner(System.in);
    public static final char Sign_X = 'X';
    public static final char Sign_O = 'O';
    public static final char Sign_Empty = '_';
    private static char[][] gameField;

    //Initializing game field
    public void initField(){
        System.out.println("Enter the size of field");
        setGameField(scan.nextInt());
    }

    public void setGameField(int fieldSize) {
        gameField= new char [fieldSize][fieldSize];
    }

    public void greeting() throws InterruptedException {
        Thread.sleep(1000);
        for(int i=5; i>0;i--) {
            if (i>1) {
                System.out.println((i) + " seconds remaining");
            }
            else {
                System.out.println((i) + " second remaining");
            }
            Thread.sleep(1000);
        }
        System.out.println("Have fun!");
    }

    public void displayField() {
        System.out.println("Game field now looks like this: ");
        for (int row = 0; row<gameField.length; row++){
            for (int col=0; col<gameField[0].length; col++){
                System.out.print(gameField[row][col]+" ");
            }
            System.out.println();
        }
    }

    //Fill the gameField of empty signs
    public void fillEmptyField(){
        for(int row = 0; row<gameField.length; row++){
            for (int col=0; col<gameField[0].length; col++){
                gameField[row][col]=Sign_Empty;
            }
        }
    }

    public static char[][] getGameField(){
        return gameField;
    }

    public boolean checkWin(char sign){
        //Check Horizontal or vertical
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if(gameField[i][0]==sign && gameField[i][1]==sign && gameField[i][2]==sign){
                    return true;
                }
                else if(gameField[0][i]==sign && gameField[1][i]==sign && gameField[2][i]==sign){
                    return true;
                }
            }
        }
        //Check Diagonal
        if (gameField[0][2] == sign && gameField[1][1] == sign && gameField[2][0] == sign) {
            return true;
        }
        else if (gameField[0][0] == sign && gameField[1][1] == sign && gameField[2][2] == sign) {
            return true;
        }
        return false;
    }

    //Check full of table
    public boolean isTableFull(){
        for(int row=0; row< gameField.length;row++){
            for(int col=0; col< gameField[0].length;col++){
                if(gameField[row][col]==Sign_Empty)
                    return false;
            }
        }
        return true;
    }

    /*//Method checks a validity of a cell
    public boolean isCellValid(int x,int y){
        if(x<0 || y<0 || x>gameField.length || y> gameField.length){
            return false;
        }
        return gameField[x][y]==Sign_Empty;
    }*/

    public static void main(String[] args) throws InterruptedException {
        Game game= new Game();
        Player1 player1= new Player1();
        Player2 player2= new Player2();
        Computer computer = new Computer();
        game.initField();
        System.out.print("Make your choice:\n1 - Player_1 vs Player_2\n2 - Player vs Computer\nAnswer: ");
        int answer = scan.nextInt();
        game.fillEmptyField();
        if (answer==2) {
            System.out.println("Playing Player vs Computer!\nPlayer playing X, Computer playing O");
            game.greeting();
            game.displayField();
        }
        else {
            System.out.println("Playing Player_1 vs Player_2!");
            game.greeting();
            game.displayField();
        }
        while(true){
            if(answer==2){
                player1.playerTurn();
                if(game.checkWin(Sign_X)){
                    game.displayField();
                    System.out.println("Player won the game. Congratulation!");
                    break;
                }
                game.displayField();
                if (game.isTableFull()){
                    game.displayField();
                    System.out.println("The game field is full. Draw!");
                    break;
                }
                computer.computerTurn();
                if(game.checkWin(Sign_O)){
                    game.displayField();
                    System.out.println("Computer won the game. I'm so sorry!\nGood luck next time!");
                    break;
                }
                game.displayField();
            }
            else{
                player1.playerTurn();
                if(game.checkWin(Sign_X)){
                    game.displayField();
                    System.out.println("Player 1 won the game. Congratulation!");
                    break;
                }
                game.displayField();
                if (game.isTableFull()){
                    game.displayField();
                    System.out.println("The game field is full. Draw!");
                    break;
                }
                player2.playerTurn();
                if(game.checkWin(Sign_O)){
                    game.displayField();
                    System.out.println("Player 2 won the game. Congratulation!");
                    break;
                }
                game.displayField();
                if (game.isTableFull()){
                    game.displayField();
                    System.out.println("The game field is full. Draw!");
                    break;
                }
            }
        }
    }
}