package org.example;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int difficulty=2;
    public static ArrayList<Block> blockChain=new ArrayList<>();

    public static void main(String[] args) {
        blockChain.add(new Block("Hi Iam the first block","0"));
        System.out.println("Trying to mine block");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Hi Iam the second block","1"));
        System.out.println("Trying to mine block");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Hi Iam the third block","2"));
        System.out.println("Trying to mine block");
        blockChain.get(2).mineBlock(difficulty);

        String blockJSON=new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println(blockJSON);
    }
    public static boolean isChainValid(){
        Block current;
        Block previous;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for(int i=1;i<blockChain.size();i++){
            current=blockChain.get(i);
            previous=blockChain.get(i-1);

            if(!current.getHash().equals(current.calculateHash())){
                System.out.println("Hash not equal");
                return false;
            }
            if(!previous.getHash().equals(previous.calculateHash())){
                System.out.println("Hash not equal");
                return false;
            }
            if(!current.getHash().substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}