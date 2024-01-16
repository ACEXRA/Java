package arraylist;

public class Main {
    public static void main(String[] args) {
        CustomArraylist<String> sb=new CustomArraylist<>();
        sb.add("Luffy");
        sb.add("Law");
        sb.add("Kidd");
        sb.add("Sabo");
        sb.add("Ace");
        System.out.println("Creation of "+sb.toString());
        sb.remove(3);
//        System.out.println("3rd index removed "+sb.toString());
    }
}
