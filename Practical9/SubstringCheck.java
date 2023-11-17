import java.util.Scanner;

public class SubstringCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        // Compare the strings to find if one is a substring of the other
        if (str1.length() > str2.length()) {
            if (str1.regionMatches(true, 0, str2, 0, str2.length())) {
                System.out.println("Second string is a substring of the first string.");
            } else {
                System.out.println("Second string is not a substring of the first string.");
            }
        } else {
            if (str2.regionMatches(true, 0, str1, 0, str1.length())) {
                System.out.println("First string is a substring of the second string.");
            } else {
                System.out.println("First string is not a substring of the second string.");
            }
        }
    }
}
