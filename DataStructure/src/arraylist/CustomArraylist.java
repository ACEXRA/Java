package arraylist;

import java.util.Arrays;

public class CustomArraylist<T>{
    private Object[] arr;
    private static int DEFAULT_SIZE=3;
    private int size=0;
    public CustomArraylist(){
        this.arr=new Object[DEFAULT_SIZE];
    }
    public CustomArraylist(int capacity){
        this.arr=new Object[capacity];
    }


    @Override
    public String toString(){
        if(size==0){
            return"[]";
        }
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(this.arr[i]);
            if(!(i==size-1))sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
    public int length(){
        return size;
    }
    public void set(int index, T value){
        this.arr[index]=value;
    }
    public void remove(int index){
        if(index>=size||index<0)throw new ArrayIndexOutOfBoundsException();
        for(int i=index;i<this.arr.length-1;i++){
            this.arr[i]=this.arr[i+1];
        }
        size--;
    }
    public void add(T value){
        if(isFull()){
            resize();
        }
        this.arr[size++]=value;
    }
    public T get(int index){
        if(index>=size)throw new ArrayIndexOutOfBoundsException();
        return (T)this.arr[index];
    }

    private void resize() {
        Object[] temp=new Object[this.arr.length+10];
        for(int i=0;i< this.arr.length;i++){
            temp[i]=this.arr[i];
        }
        this.arr=temp;
    }

    private boolean isFull() {
        return size== arr.length;
    }
}
