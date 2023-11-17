import java.util.Scanner;

public class ShiftCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to encrypt:");
        String word = scanner.nextLine().toLowerCase();

        System.out.println("Enter the shift value:");
        int shift = scanner.nextInt();

        String encryptedWord = encryptWord(word, shift);
        System.out.println("Encrypted word: " + encryptedWord);
    }

    public static String encryptWord(String word, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                int charValue = c - 'a'; // Convert character to 0-25 range
                charValue = (charValue + shift) % 26; // Apply shift within 0-25 range
                if (charValue < 0) {
                    charValue += 26; // Handle negative values after shifting
                }
                char encryptedChar = (char) (charValue + 'a'); // Convert back to character
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(c); // Non-alphabetic characters remain unchanged
            }
        }

        return encrypted.toString();
    }
}
