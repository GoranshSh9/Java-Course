import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int ans = 0;
            OUTER:
            while (true) {
                System.out.println("Enter the Operation: ");
                char op = in.next().trim().charAt(0);
                switch (op) {
                    case '+', '-', '*', '/', '%' -> {
                        System.out.println("Enter the numbers: ");
                        int num1 = in.nextInt();
                        int num2 = in.nextInt();
                        if (op == '+') {
                            ans = num1 + num2;
                        }   if (op == '-') {
                            ans = num1 - num2;
                        }   if (op == '*') {
                            ans = num1 * num2;
                        }   if (op == '/') {
                            if (num2 != 0) {
                                ans = num1 / num2;
                            }
                        }   if (op == '%') {
                            ans = num1 % num2;
                        }
                    }
                    case 'x', 'X' -> {
                        break OUTER;
                    }
                    default -> System.out.println("Invalid Operation!!");
                }
                System.out.println("Answer: " + ans);
            }
        }
    }
}