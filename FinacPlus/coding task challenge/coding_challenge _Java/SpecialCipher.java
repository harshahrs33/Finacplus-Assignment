import java.util.*;
public class SpecialCipher {

    // Caesar Cipher method
    public static String caesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (base + (c - base + shift) % 26));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // Run-Length Encoding method
    public static String runLengthEncode(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        StringBuilder encodedText = new StringBuilder();
        char prevChar = text.charAt(0);
        int count = 1;

        for (int i = 1; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                encodedText.append(prevChar);
                if (count > 1) {
                    encodedText.append(count);
                }
                prevChar = currentChar;
                count = 1;
            }
        }

        encodedText.append(prevChar);
        if (count > 1) {
            encodedText.append(count);
        }

        return encodedText.toString();
    }

    // Special Cipher method combining Caesar Cipher and RLE
    public static String specialCipher(String text, int shift) {
        String caesarText = caesarCipher(text, shift);
        return runLengthEncode(caesarText);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String input = sc.nextLine();
        System.out.print("Enter the key : ");
        int shift = sc.nextInt();
        String output = specialCipher(input, shift);
        System.out.println(output);  
    }
}