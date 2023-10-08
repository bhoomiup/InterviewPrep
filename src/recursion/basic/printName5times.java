package recursion.basic;

public class printName5times {

    public static void printName(int noOfTimes){
        if (noOfTimes == 0){
            return;
        }
        System.out.println("Bhoomika");
        noOfTimes--;
        printName(noOfTimes);
    }

    public static void main(String[] args) {
        printName(5);
    }
}
