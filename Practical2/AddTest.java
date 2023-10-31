import java.util.Scanner;
public class AddTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x :"); int x = input.nextInt();
        System.out.print("Enter y :"); int y = input.nextInt();
        if (x > y) {
            System.out.printf("%s%n","There is an error");
        }
        else if (x <= y) {
            int total = 0;
            int counter = x;
            while (counter <= y) {
                total = total + counter;
                counter += 1;
            }
            System.out.printf("The sum is :%d%n",total);
        }
    }
}