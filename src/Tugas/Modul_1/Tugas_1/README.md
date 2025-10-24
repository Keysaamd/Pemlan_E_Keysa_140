# Average Calculator

Program sederhana untuk menghitung nilai rata-rata dari sejumlah angka yang dimasukkan oleh pengguna.

## Deskripsi

Program ini memungkinkan pengguna untuk:
- Memasukkan jumlah angka yang ingin dihitung rata-ratanya
- Memasukkan angka-angka satu per satu
- Mendapatkan hasil perhitungan rata-rata
- Mendapatkan pesan error yang informatif jika terjadi kesalahan input

## Fitur

- **Validasi Input**: Memastikan input yang dimasukkan adalah angka yang valid
- **Exception Handling**: Menangani berbagai jenis kesalahan input dengan pesan error yang jelas
- **User-Friendly**: Antarmuka yang mudah dipahami dengan petunjuk yang jelas
- **Error Handling Types**:
    - Input bukan angka
    - Jumlah angka negatif
    - Jumlah angka nol atau negatif
    - Kesalahan umum lainnya

## Cara Menggunakan

1. Compile program:
   ```bash
   javac AverageCalculator.java
   ```

2. Jalankan program:
   ```bash
   java AverageCalculator
   ```

3. Ikuti instruksi yang muncul:
    - Masukkan jumlah angka yang ingin dihitung
    - Masukkan angka-angka satu per satu
    - Program akan menampilkan hasil rata-rata

## Contoh Penggunaan

```
Masukkan jumlah angka: 3
Masukkan angka-angka: 
10
20
30
Rata-rata adalah: 20.0
Program selesai!.
```

## Contoh Penanganan Error

```
Masukkan jumlah angka: -5
Error: Jumlah angka harus lebih besar dari 0
Program selesai!.
```

```
Masukkan jumlah angka: abc
Error: Input harus berupa angka!
Program selesai!.
```

## Teknologi yang Digunakan

- Java
- Scanner untuk input
- Exception Handling
- Array untuk penyimpanan data

## Struktur Kode

- `InputMismatchException`: Menangani input yang bukan angka
- `NegativeArraySizeException`: Menangani jumlah angka negatif
- `finally block`: Memastikan Scanner ditutup dan menampilkan pesan akhir

## Requirements

- Java JDK 8 atau lebih tinggi
- Terminal/Command Prompt untuk menjalankan program