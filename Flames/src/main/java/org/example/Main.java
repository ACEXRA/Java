package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.nextLine();
        String s2=sc.nextLine();

        //Removing all whitespace and uppercase to lowercase for comparsion
        String s3=s1.replaceAll("\\s","").toLowerCase();
        String s4=s2.replaceAll("\\s","").toLowerCase();
        System.out.println(flames(s3,s4));
    }
    public static String flames(String s1,String s2){
        String result="";
        StringBuilder s3=new StringBuilder(s1);
        StringBuilder s4=new StringBuilder(s2);
        int len=0;
        //Matching the two string and finding the number od distinct letters
        for(int i=0;i<s3.length();i++){
            for(int j=0;j<s4.length();j++){
                if(s3.charAt(i)==s4.charAt(j)){
                    s3.setCharAt(i,'-');
                    s4.setCharAt(j,'-');
                    len+=2;
                    break;
                }
            }
        }
        //calculate how many time we count in Flames
        int loopLength=s1.length()+s2.length()-len;
        StringBuilder flames=new StringBuilder("flames");
        //substring the flames to find the last character
        while(flames.length()>1){
            String temp;
            int n=loopLength%flames.length();
            if(n!=0){
                temp=flames.substring(n)+flames.substring(0,n-1);
            }else{
                temp=flames.substring(n,flames.length()-1);
            }
            flames=new StringBuilder(temp);
        }
        //resulting the answer
        switch (flames.toString()){
            case "f":
                result="Friends";
                break;
            case "l":
                result="Love";
                break;
            case "a":
                result="Attraction";
                break;
            case "m":
                result="Marriage";
                break;
            case "e":
                result="Enemy";
                break;
            case "s":
                result="Sibling";
                break;
            default:
                return "Something went wrong";
        }
        return result;
    }
}