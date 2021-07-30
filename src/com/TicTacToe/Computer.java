package com.TicTacToe;

import java.util.Random;

import static com.TicTacToe.Game.*;

public class Computer {

    private static int row,col;

    public static void computerTurn(){
        Random random = new Random();
        row = random.nextInt(Game.getGameField().length);
        col = random.nextInt(Game.getGameField().length);
        checkloop:
        while(true){
            System.out.println("Computer's turn!");
            //Check diagonal for Computer's win
            if (getGameField()[0][0]==Sign_O && getGameField()[1][1]==Sign_O){
                getGameField()[2][2]=Sign_O;
                break checkloop;
            }
            else if (getGameField()[2][2]==Sign_O && getGameField()[1][1]==Sign_O){
                getGameField()[0][0]=Sign_O;
                break checkloop;
            }
            else if (getGameField()[0][0]==Sign_O && getGameField()[2][2]==Sign_O){
                getGameField()[1][1]=Sign_O;
                break checkloop;
            }
            //Computer checks chance for his win by diagonal or vertical
            for (int i = 0; i <getGameField().length ; i++) {
                //Check win vertical
                if (getGameField()[i][0]==Sign_O && getGameField()[i][1]==Sign_O){
                    getGameField()[i][2]=Sign_O;
                    break checkloop;
                }
                else if (getGameField()[i][2]==Sign_O && getGameField()[i][1]==Sign_O){
                    getGameField()[i][0]=Sign_O;
                    break checkloop;
                }

                else if (getGameField()[i][0]==Sign_O && getGameField()[i][2]==Sign_O){
                    getGameField()[i][1]=Sign_O;
                    break checkloop;
                }
                //Check horizontal
                else if (getGameField()[0][i]==Sign_O && getGameField()[1][i]==Sign_O){
                    getGameField()[i][2]=Sign_O;
                    break checkloop;
                }
                else if (getGameField()[2][i]==Sign_O && getGameField()[1][i]==Sign_O){
                    getGameField()[0][i]=Sign_O;
                    break checkloop;
                }

                else if (getGameField()[0][i]==Sign_O && getGameField()[2][i]==Sign_O){
                    getGameField()[1][i]=Sign_O;
                    break checkloop;
                }
            }
            //Computer checks chance for win enemy by diagonal or vertical
            for (int i = 0; i <getGameField().length; i++) {
                //Check vertical
                if (getGameField()[i][0]==Sign_X && getGameField()[i][1]==Sign_X && cellValid(i,2)){
                    getGameField()[i][2]=Sign_O;
                    break checkloop;
                }
                else if (getGameField()[i][2]==Sign_X && getGameField()[i][1]==Sign_X && cellValid(i,0)){
                    getGameField()[i][0]=Sign_O;
                    break checkloop;
                }

                else if (getGameField()[i][0]==Sign_X && getGameField()[i][2]==Sign_X && cellValid(i,1)){
                    getGameField()[i][1]=Sign_O;
                    break checkloop;
                }
                //Check horizontal
                else if (getGameField()[0][i]==Sign_X && getGameField()[1][i]==Sign_X && cellValid(i,2)){
                    getGameField()[i][2]=Sign_O;
                    break checkloop;
                }
                else if (getGameField()[2][i]==Sign_X && getGameField()[1][i]==Sign_X && cellValid(0,i )){
                    getGameField()[0][i]=Sign_O;
                    break checkloop;
                }

                else if (getGameField()[0][i]==Sign_X && getGameField()[2][i]==Sign_X && cellValid(1,i)){
                    getGameField()[1][i]=Sign_O;
                    break checkloop;
                }
            }
            //Check diagonal for enemy's win
            if (getGameField()[0][0]==Sign_X && getGameField()[1][1]==Sign_X && cellValid(2,2)){
                getGameField()[2][2]=Sign_O;
                break checkloop;
            }
            if (getGameField()[2][2]==Sign_X && getGameField()[1][1]==Sign_X && cellValid(0,0)){
                getGameField()[0][0]=Sign_O;
                break checkloop;
            }
            if (getGameField()[0][0]==Sign_X && getGameField()[2][2]==Sign_X && cellValid(1,1)){
                getGameField()[1][1]=Sign_O;
                break checkloop;
            }

            //Check
            else if(cellValid(row,col)) {
                getGameField()[row-1][col-1] = Sign_O;
                break checkloop;
            }
        }
    }
    public static boolean cellValid(int row, int col){
        return row > 0 && col > 0 && row  < getGameField().length && col < getGameField()[0].length && getGameField()[row][col] == Sign_Empty;
    }
}