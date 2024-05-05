import java.util.Scanner;

public class EncryptMessage {
    public static void main(String[] args) {
        // Check if the correct number of command-line arguments is provided
        if (args.length != 1) {
            System.out.println("Usage: java EncryptMessage <key>");
            System.exit(1);
        }

        // Check if every character in args[0] is a digit
        for (char c : args[0].toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Usage: java EncryptMessage <key>");
                System.exit(1);
            }
        }

        // Convert args[0] from a String to an int
        int k = Integer.parseInt(args[0]);

        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Your message: ");
        String message = scanner.nextLine();

        System.out.print("Encrypted message: ");

        // For each character in the message
        for (char c : message.toCharArray()) {
            char encryptedChar = c;

            // Rotate the character if it's a letter
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedChar = (char) (((c - base + k) % 26) + base);
            }

            System.out.print(encryptedChar);
        }

        System.out.println();

        // Close the Scanner object
        scanner.close();
    }
}
