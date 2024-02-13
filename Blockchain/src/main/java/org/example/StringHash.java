package org.example;

import java.security.MessageDigest;

public class StringHash {
    public static String stringHash(String input){
        try{
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
            byte[] hash=messageDigest.digest(input.getBytes("UTF-8"));
            StringBuilder hexaString=new StringBuilder();
            for(int i=0;i<hash.length;i++){
                String hex=Integer.toHexString(0xff&hash[i]);
                if(hex.length()==1)hexaString.append('0');
                hexaString.append(hex);
            }
            return hexaString.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
