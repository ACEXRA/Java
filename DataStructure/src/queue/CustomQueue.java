package queue;

public class CustomQueue<T> {
    private Object[] arr;
    private static int DEFAULT_SIZE=10;
    private int size=0;
    CustomQueue(){
        this.arr=new Object[DEFAULT_SIZE];
    }
    public T peek(){
        return (T)arr[0];
    }
    public T pop(){
        if(size==0) throw new ArrayIndexOutOfBoundsException("No elements in Stack");
        T value=(T)arr[0];
        for(int i=1;i<size;i++){
            this.arr[i-1]=this.arr[i];
        }
        size--;
        return value;
    }
    public void push(T value){
        if(isFull()){
            grow();
        }
        this.arr[size++]=value;
    }
    public int size(){
        return size;
    }
    private boolean isFull(){
        return this.arr.length==size;
    }
    private void grow(){
        Object[] temp=new Object[this.size*2];
        for(int i=0;i<this.arr.length;i++){
            temp[i]=this.arr[i];
        }
        this.arr=temp;
    }

}
