package org.example;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static ArrayList<Block> blockArrayList=new ArrayList<>(0);

    public static void main(String[] args) {
//        Block genesisBlock = new Block("Hi im the first block", "0");
//        System.out.println("Hash for block 1 : " + genesisBlock.getHash());
//        Block secondBlock = new Block("Yo im the second block",genesisBlock.getHash());
//        System.out.println("Hash for block 2 : " + secondBlock.getHash());
//        Block thirdBlock = new Block("Hey im the third block",secondBlock.getHash());
//        System.out.println("Hash for block 3 : " + thirdBlock.getHash());

        blockArrayList.add(new Block("Hi I am first block","0"));
        blockArrayList.add(new Block("Hi i am second block",blockArrayList.get(blockArrayList.size()-1).getHash()));
        blockArrayList.add(new Block("Hi i am third block",blockArrayList.get(blockArrayList.size()-1).getHash()));

        String blockChainJson=new GsonBuilder().setPrettyPrinting().create().toJson(blockArrayList);
        System.out.println(blockChainJson);
        blockArrayList.get(2).setData("data tampered");
        System.out.println(Main.isCHainValid());
        System.out.println(blockChainJson);
    }

    public static boolean isCHainValid(){
        Block currentBlock;
        Block previousBlock;

        for(int i=1;i<blockArrayList.size();i++){
            currentBlock=blockArrayList.get(i);
            previousBlock=blockArrayList.get(i-1);
            if(!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Current hashes are not equal");
                return false;
            }
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash())){
                System.out.println("Previous hashes are not equal");
                return false;
            }
        }
        return true;
    }

}