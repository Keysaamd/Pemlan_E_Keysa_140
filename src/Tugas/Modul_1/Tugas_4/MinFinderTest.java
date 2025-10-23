package Tugas.Modul_1.Tugas_4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinFinderTest {

    @Test
    void testCariNilaiMinimum_Skenario1() {
        printTestHeader("SKENARIO 1 - ANGKA POSITIF");
        System.out.println("📥 Input    : a = 1, b = 2, c = 3");

        int hasil = MinFinder.findMin(1, 2, 3);

        System.out.println("📤 Output   : " + hasil);
        System.out.println("🎯 Expected : 3");

        assertEquals(3, hasil);

        printTestResult("BERHASIL", true);
    }

    @Test
    void testCariNilaiMinimum_Skenario2() {
        printTestHeader("SKENARIO 2 - ANGKA NEGATIF");
        System.out.println("📥 Input    : a = -1, b = -2, c = -3");

        int hasil = MinFinder.findMin(-1, -2, -3);

        System.out.println("📤 Output   : " + hasil);
        System.out.println("🎯 Expected : -1");

        assertEquals(-1, hasil);

        printTestResult("BERHASIL", true);
    }

    @Test
    void testCariNilaiMinimum_Skenario3() {
        printTestHeader("SKENARIO 3 - ANGKA SAMA & POSITIF");
        System.out.println("📥 Input    : a = 0, b = 0, c = 1");

        int hasil = MinFinder.findMin(0, 0, 1);

        System.out.println("📤 Output   : " + hasil);
        System.out.println("🎯 Expected : 0");

        assertEquals(0, hasil);

        printTestResult("BERHASIL", true);
    }

    // Method untuk header yang rapi
    private void printTestHeader(String title) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    " + title + "             ");
        System.out.println("╠════════════════════════════════════════╣");
    }

    // Method untuk hasil test yang rapi
    private void printTestResult(String status, boolean success) {
        System.out.println("╠════════════════════════════════════════╣");
        if (success) {
            System.out.println("║ ✅ " + status + "                         ");
        } else {
            System.out.println("║ ❌ " + status + "                         ");
        }
        System.out.println("╚════════════════════════════════════════╝");
    }
}