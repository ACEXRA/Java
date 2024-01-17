package queue;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Main");
        CustomQueue<Integer> cs=new CustomQueue<>();
        cs.push(5);
        cs.push(10);
        cs.push(15);
        cs.push(20);
        cs.push(25);
        cs.push(30);
        System.out.println(cs.size());
        System.out.println(cs.peek());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
    }
}
