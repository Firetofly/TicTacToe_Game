package com.TicTacToe;

import java.lang.InterruptedException;
import java.lang.System;
import java.lang.Thread;
import java.util.Objects;
import java.util.Scanner;

public class Game{

    static Scanner scan = new Scanner(System.in);
    private static boolean Player1_win= false;
    private static boolean Player2_win= false;
    private static final char Sign_X = 'X';
    private static final char Sign_O = 'O';
    private static final char Sign_Empty = '_';
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

    public static void displayField() {
        System.out.println("Game field now looks like this: ");
        for (int row = 0; row<gameField.length; row++){
            for (int col=0; col<gameField[0].length; col++){
                System.out.print(gameField[row][col]+" ");
            }
            System.out.println();
        }
    }

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

    public static void checkWin(){

    }






}