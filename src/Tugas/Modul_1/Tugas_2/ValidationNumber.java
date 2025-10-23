package Tugas.Modul_1.Tugas_2;

import java.util.Scanner;

class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }
}

public class ValidationNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Masukkan angka positif: ");
                double number = scanner.nextDouble();

                validatePositiveNumber(number);
                System.out.println("✓ Valid! Angka " + number + " adalah angka positif.");
                isValid = true;

            } catch (InvalidNumberException e) {
                System.out.println("❌ " + e.getMessage());
                System.out.println("Silakan coba lagi.\n");
            } catch (Exception e) {
                System.out.println("❌ Error: Input harus berupa angka!");
                scanner.nextLine(); // Clear buffer
                System.out.println("Silakan coba lagi.\n");
            }
        }
        scanner.close();
    }

    public static void validatePositiveNumber(double number) throws InvalidNumberException {
        if (number <= 0) {
            throw new InvalidNumberException("Angka harus positif!");
        }
    }
}