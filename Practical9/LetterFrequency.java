import java.util.Scanner;

public class LetterFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a line of text:");
        String line = scanner.nextLine().toLowerCase();

        int[] frequency = new int[26]; // Frequency array for 26 letters

        // Count the frequency of each letter
        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = c - 'a';
                frequency[index]++;
            }
        }

        // Print the letter frequency table
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                char letter = (char) ('a' + i);
                System.out.println(letter + ": " + frequency[i]);
            }
        }
    }
}
