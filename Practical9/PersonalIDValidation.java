import java.util.Scanner;

public class PersonalIDValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a personal ID code (DDMMYY-XXXX):");
        String personalID = scanner.nextLine();

        // Regular expression pattern for the ID code format
        String pattern = "\\b(0[1-9]|[1-2][0-9]|3[0-1])(0[1-9]|1[0-2])(\\d{2})-(\\p{Alnum}{4})\\b";

        // Check if the input matches the pattern
        if (personalID.matches(pattern)) {
            System.out.println("Valid personal ID code.");
        } else {
            System.out.println("Invalid personal ID code.");
        }
    }
}
