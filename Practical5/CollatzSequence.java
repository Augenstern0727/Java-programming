import java.util.Scanner;


public class CollatzSequence {
    /*
    Task1-2

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a positive integer (n): ");
            int n = scanner.nextInt();

            if (isPositiveInteger(n)) {
                System.out.println("Collatz sequence for n = " + n + ":");
                printCollatzSequence(n);
            } 
            else {
                throw new IllegalArgumentException("Please use a valid positive integer.");
            }
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input: Please enter a positive integer.");
        } 
        finally {
            scanner.close();
        }
    }

    public static void printCollatzSequence(int n) {
        System.out.print(n + " ");

        if (n == 1) {
            return;
        } 
        else if (n % 2 == 0) {
            printCollatzSequence(n / 2);
        } 
        else {
            printCollatzSequence(3 * n + 1);
        }
    }
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a positive integer (n): ");
            int n = scanner.nextInt();

            if (isPositiveInteger(n)) {
                int steps = countCollatzSteps(n);
                System.out.println("For initial n = " + n + ", it took " + steps + " steps to reach 1.");
            } 
            else {
                throw new IllegalArgumentException("Please use a valid positive integer.");
            }
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } 
        catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input: Please enter a positive integer.");
        } 
        finally {
            scanner.close();
        }
    }

    public static int countCollatzSteps(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 0;
        } 
        else if (n % 2 == 0) {
            return 1 + countCollatzSteps(n / 2);
        } 
        else {
            return 1 + countCollatzSteps(3 * n + 1);
        }
    }

    public static boolean isPositiveInteger(int n) {
        return n > 0;
    }
}