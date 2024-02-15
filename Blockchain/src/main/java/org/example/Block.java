package org.example;

import java.util.Date;

public class Block {
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    public int mine;

    public Block( String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash=calculateHash();
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String calculateHash(){
        return StringHash.stringHash(previousHash+Long.toString(timeStamp)+data);

    }
}
