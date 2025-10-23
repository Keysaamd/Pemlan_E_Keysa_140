package Modul_1.Codelab_2;

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CodeLab2 {
    public static void validasiUsia(int usia) throws InvalidAgeException{
        if (usia <= 0){
            throw new InvalidAgeException("Usia harus lebih dari 0");
        }
        if (usia >= 120){
            throw new InvalidAgeException("Usia tidak boleh lebih dari 120");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Usia: ");
        int usia = scanner.nextInt();
        scanner.close();

        try {
            validasiUsia(usia);
            System.out.println("Usia valid: " + usia);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
