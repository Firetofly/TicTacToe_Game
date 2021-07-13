package com.TicTacToe;

import java.util.Scanner;

public class Player1 {
    private int column,row;

    public static void player1Turn(){
        while(true){
            try{
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter a cell (row and column) with space from 1 to" + Game.getGameField().length);
                int row = scan.nextInt();
                int column = scan.nextInt();
                if (Game.getGameField()[row-1][column-1]==Game.Sign_Empty) {
                    Game.getGameField()[row-1][column-1]=Game.Sign_X;
                    break;
                }
                else System.out.println("Cell is not empty, try again!");
            } catch (Exception e) {
                System.out.println("Unexpected error, please try again");
            }
        }

    }
}

