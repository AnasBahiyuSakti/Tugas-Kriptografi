package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu utama enkripsi dan dekripsi dengan Caesar Cipher");
        System.out.println("1. Encoding");
        System.out.println("2. Decoding");
        int menuInsert = scanner.nextInt();

        if(menuInsert == 1) {
            String error = scanner.nextLine();
            System.out.println("Masukkan teks yang ingin dienkripsi");
            String plainText = scanner.nextLine();
            System.out.println("Masukkan key enkripsi!");
            int key = scanner.nextInt();
            System.out.println(enkripsi(plainText, key));
        } else {
            String error2 = scanner.nextLine();
            System.out.println("Masukkan teks yang ingin didekripsi");
            String plainText = scanner.nextLine();
            System.out.println("Masukkan key enkripsi!");
            int key = scanner.nextInt();
            System.out.println(dekripsi(plainText, key));
        }
    }

    public static String enkripsi(String plainText, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String cipherText = "";
        plainText = plainText.toLowerCase();
        for(int i = 0; i < plainText.length(); i++) {
            int alphabetIndex = alphabet.indexOf(plainText.charAt(i));
            int cipherIndex = (alphabetIndex + key) % 26;
            char cipherCharacter = alphabet.charAt(cipherIndex);
            cipherText = cipherText + cipherCharacter;
        }
        return cipherText;
    }

    public static String dekripsi(String cipherText, int key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String plainText = "";
        cipherText = cipherText.toLowerCase();

        for(int i = 0; i < cipherText.length(); i++) {
            int alphabetIndex = alphabet.indexOf(cipherText.charAt(i));
            int plainTextIndex = (alphabetIndex - key) % 26;
            if (plainTextIndex < 0){
                plainTextIndex = alphabet.length() + plainTextIndex;
            }
            char plainTextCharacter = alphabet.charAt(plainTextIndex);
            plainText = plainText + plainTextCharacter;
        }
        return plainText;
    }
}
