
import java.util.Scanner;

public class DescribeFruit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Fruit = in.next();

        switch (Fruit){
            case "Mango":
                System.out.println("The king of fruits");
                break;
            case "Apple":
                System.out.println("A sweet red fruit");
                break;
            case "Orange":
                System.out.println("Round fruit");
                break;
            default:
                System.out.println("Please enter a valid fruit");
        in.close();
        }
    }
}