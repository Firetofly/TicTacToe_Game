package com.TicTacToe;

import java.util.Scanner;

public class Game{

    static Scanner scan = new Scanner(System.in);
    private static boolean Player1_win= false;
    private static boolean Player2_win= false;
    private static final char Sign_X = 'X';
    private static final char Sign_O = 'O';
    private static final char Sign_Empty = '_';
    private static char[][] gameField;

    private static void startGame(){
        for(int i1=0; i1<=3; i1++){

            }
        }
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








}