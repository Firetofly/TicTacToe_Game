package com.TicTacToe;

import java.util.Scanner;
import java.lang.InterruptedException;

public class Game{

    static Scanner scan = new Scanner(System.in);
    /*private boolean Player1_win= false;
     private boolean Player2_win= false;*/
    public static final char Sign_X = 'X';
    public static final char Sign_O = 'O';
    public static final char Sign_Empty = '_';
    private static char[][] gameField;

    //Initializing game field
    public static void initField(){
        System.out.println("Enter the size of field");
        setGameField(scan.nextInt());
    }

    public static void setGameField(int fieldSize) {
        gameField= new char [fieldSize][fieldSize];
    }

    public static void greeting() throws InterruptedException {
        System.out.println("Welcome to the 'Tic-Tac-Toe' game V1.0");
        Thread.sleep(1000);
        for(int i=5; i>=0;i--) {
            if (i>1) {
                System.out.println((i + 1) + " seconds remaining");
            }
            else {
                System.out.println((i + 1) + " second remaining");
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

    //Fill the gameFiel of empty signs
    public static void fillEmptyField(){
        for(int row = 0; row<gameField.length; row++){
            for (int col=0; col<gameField[0].length; col++){
                gameField[row][col]=Sign_Empty;
            }
        }
    }

    public static char[][] getGameField(){
        return gameField;
    }

    public static boolean checkWin(char sign){
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
    public static boolean isTableFull(){
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
        System.out.println("Enter the size of game field");
        int size = scan.nextInt();
        setGameField(size);
        fillEmptyField();
        greeting();

        while(true){
            Player1.player1Turn();
            if (isTableFull()){
                System.out.println("The game field is full. Draw!");
            }

        }

    }


}