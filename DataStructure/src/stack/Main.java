package stack;

public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> cus=new CustomStack<>();
        System.out.println(cus.isEmpty());
        cus.push(12);
        cus.push(22);
        cus.push(232);
    }
}
