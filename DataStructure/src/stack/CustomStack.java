package stack;

public class CustomStack<T>{
    private Object[] arr;
    private static int DEFAULT_SIZE=10;
    private int size=0;

    CustomStack(){
        this.arr=new Object[DEFAULT_SIZE];
    }

    public int size(){
        return size;
    }
    public T peek(){
        return (T)arr[size-1];
    }
    public T pop(){
        if(size==0)throw new ArrayIndexOutOfBoundsException();
        Object value=arr[size-1];
        size--;
        return (T)value;
    }
    public void push(T value){
        if(isFull()){
            grow();
        }
        arr[size++]=value;
    }
    public void grow(){
        Object[] temp=new Object[arr.length*2];
        for (int i=0;i<this.arr.length;i++){
            temp[i]=this.arr[i];
        }
        this.arr=temp;
    }
    public boolean isFull(){
        return arr.length==size;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
