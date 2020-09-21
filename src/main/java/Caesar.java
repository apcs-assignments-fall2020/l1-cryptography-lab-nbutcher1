import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String enc = "";
        for (int i = 0; i < message.length(); i ++) {
            char ch = message.charAt(i);
            if (ch> 64 && ch < 91) {
                int num = ch + 3;
                if (num > 90) 
                    num -= 26;
                ch = (char)num;
                enc += ch;
            }
            else if (ch > 96 && ch < 123) {
                int num = ch + 3;
                if (num > 122)
                    num -= 26;
                ch = (char)num;
                enc += ch;
            }
             else {
               enc += ch; 
            }
        }
        return enc;
        
    }

    public static String decryptCaesar(String message) {
        String enc = "";
        for (int i = 0; i < message.length(); i ++) {
            char ch = message.charAt(i);
            if (ch> 64 && ch < 91) {
                int num = ch - 3;
                if (num < 65) 
                    num += 26;
                ch = (char)num;
                enc += ch;
            }
            else if (ch > 96 && ch < 123) {
                int num = ch - 3;
                if (num < 97)
                    num += 26;
                ch = (char)num;
                enc += ch;
            }
             else {
               enc += ch; 
            }
        }
        return enc;
        
    }

    public static String encryptCaesarKey(String message, int key) {
        String enc = "";
        for (int i = 0; i < message.length(); i ++) {
            char ch = message.charAt(i);
            if (ch> 64 && ch < 91) {
                int num = ch + key;
                num = num%65 + 65;
                if (num > 90) 
                    num -= 26;
                ch = (char)num;
                enc += ch;
            }
            else if (ch > 96 && ch < 123) {
                int num = ch + key;
                num = num%97 + 97;
                if (num > 122)
                    num -= 26;
                ch = (char)num;
                enc += ch;
            }
             else {
               enc += ch; 
            }
        }
        return enc;
    }

    public static String decryptCaesarKey(String message, int key) {
        String enc = "";
        for (int i = 0; i < message.length(); i ++) {
            char ch = message.charAt(i);
            if (ch> 64 && ch < 91) {
                int num = ch - (key % 26);
                if (num < 65) 
                    num += 26;
                num = num%65 + 65;
                ch = (char)num;
                enc += ch;
            }
            else if (ch > 96 && ch < 123) {
                int num = ch - (key % 26);
                if (num < 97)
                    num += 26;
                num = num%97 + 97;
                ch = (char)num;
                enc += ch;
            }
             else {
               enc += ch; 
            }
        }
        return enc;
        
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your key: ");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message,key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your key: ");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message,key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
