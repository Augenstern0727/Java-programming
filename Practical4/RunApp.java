import java.util.Scanner;

public class RunApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("Enter the first number (or 'q' to quit): ");
            if (scanner.hasNext("q") || scanner.hasNext("Q")) {
                break; 
            }

            int num1 = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter the operator (+, -, *, or 'q' to quit): ");
            char operator = scanner.next().charAt(0);

            if (operator == 'q' || operator == 'Q') {
                break; 
            }

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            scanner.nextLine();

            int result = 0;

            if (operator == '+') {
                result = calculator.add(num1, num2);
            } else if (operator == '-') {
                result = calculator.subtract(num1, num2);
            } else if (operator == '*') {
                result = calculator.multiply(num1, num2);
            } else {
                System.out.println("Invalid operator. Please enter '+', '-', '*', or 'q' to quit.");
                continue;
            }

            System.out.println("Result: " + result);
        }
    }
}