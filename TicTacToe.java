package com.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public void play(){
        System.out.println("Game begins");
        String[][] arr=new String[3][3];
        int count=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.toString(count);
                count++;
            }
        }
        print(arr);
        Scanner sc= new Scanner(System.in);
        boolean gameWon=false;
        boolean draw=false;
        String player="X";
        while(!gameWon & !draw){
            String location= sc.next();
            String status=setValue(arr,location,player);
            print(arr);
            System.out.println(status);
            if(!status.equals("Enter a valid choice"))player= player.equals("X") ?"O":"X";
            gameWon=checkWinStatus(arr);
            draw=checkDrawStatus(arr);
            if(gameWon)player=player.equals("X")?"O":"X";
        }
        if(gameWon){
            System.out.println("The winner is "+player);
        }
        if(draw){
            System.out.println("The match is draw");
        }
    }

    public boolean checkWinStatus(String[][] arr){
        if(arr[0][0].equals(arr[0][1])&&arr[0][1].equals(arr[0][2]))return true;
        if(arr[0][0].equals(arr[1][0])&&arr[1][0].equals(arr[2][0]))return true;
        if(arr[2][0].equals(arr[2][1])&&arr[2][1].equals(arr[2][2]))return true;
        if(arr[0][2].equals(arr[1][2])&&arr[1][2].equals(arr[2][2]))return true;
        if(arr[0][0].equals(arr[1][1])&&arr[1][1].equals(arr[2][2]))return true;
        if(arr[0][2].equals(arr[1][1])&&arr[1][1].equals(arr[2][0]))return true;
        if(arr[0][1].equals(arr[1][1])&&arr[1][1].equals(arr[2][1]))return true;
        if(arr[1][0].equals(arr[1][1])&&arr[1][1].equals(arr[1][2]))return true;
        return false;
    }

    public boolean checkDrawStatus(String[][] arr){
        int count=0;
        int checkCount=9;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                count++;
                if(!arr[i][j].equals(Integer.toString(count))){
                    checkCount--;
                }
            }
        }
        return checkCount==0;
    }
    public String setValue(String[][] arr,String location,String player){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(arr[i][j].equals(location)){
                    arr[i][j]=player;
                    return "Next Turn";
                }
            }
        }
        return "Enter a valid choice";
    }
    public void print(String[][] arr){
        for(int i=0;i<3;i++){
            System.out.println();
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]);
                System.out.print("|");
            }
            System.out.println();
            System.out.print("--------");
        }
        System.out.println();
    }
}
