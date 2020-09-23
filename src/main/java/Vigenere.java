import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        int oof = key.length();
        String finalstr = "";
        int x = 0;
        for (int i = 0; i < message.length(); i ++) {
            if ((int)message.charAt(i) >= 65 && (int)message.charAt(i) <= 90) {
                int shift = ((int)(key.charAt((i-x)%oof)) % 65);
                int ok = (int)message.charAt(i) + shift;
                if (ok > 90)
                    ok-=26;
                if (ok < 65)
                    ok += 26;
                char ch = (char)ok;
                finalstr += ch;
            }
            else if ((int)message.charAt(i) >= 97 && (int)message.charAt(i) <= 122) {
                int shift = ((int)(key.charAt((i-x)%oof)) % 65);
                int ok = (int)message.charAt(i) + shift;
                if (ok > 122)
                    ok-=26;
                if (ok < 97)
                    ok += 26;
                char ch = (char)ok;
                finalstr += ch;
            }
            else {
                x += 1;
                finalstr += (message.charAt(i));
            }
        }
        return finalstr;
        
    }


    public static String decryptVigenere(String message, String key) {
        int oof = key.length();
        String finalstr = "";
        int x = 0;
        for (int i = 0; i < message.length(); i ++) {
            if ((int)message.charAt(i) >= 65 && (int)message.charAt(i) <= 90) {
                int shift = ((int)(key.charAt((i-x)%oof)) % 65);
                int ok = (int)message.charAt(i) - shift;
                if (ok > 90)
                    ok-=26;
                if (ok < 65)
                    ok += 26;
                char ch = (char)ok;
                finalstr += ch;
            }
            else if ((int)message.charAt(i) >= 97 && (int)message.charAt(i) <= 122) {
                int shift = ((int)(key.charAt((i-x)%oof)) % 65);
                int ok = (int)message.charAt(i) - shift;
                if (ok > 122)
                    ok-=26;
                if (ok < 97)
                    ok += 26;
                char ch = (char)ok;
                finalstr += ch;
            }
            else {
                x += 1;
                finalstr += (message.charAt(i));
            }
        }
        return finalstr;
        
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
