# Train Ticket Management System

Sebuah sistem manajemen tiket kereta api yang dibuat dengan Java menggunakan konsep Object-Oriented Programming (OOP) yang mencakup encapsulation, inheritance, polymorphism, dan abstraction.

## Deskripsi

Program ini mensimulasikan sistem pemesanan tiket kereta api dengan fitur-fitur lengkap untuk manajemen tiket elektronik. Sistem ini dirancang dengan arsitektur berlapis yang mudah dipelihara dan dikembangkan.

## Fitur Utama

- **Pembuatan tiket** dengan data lengkap penumpang dan perjalanan
- **Informasi detail** rute, jadwal, dan harga
- **Perubahan kursi** dengan validasi nomor kursi
- **Upgrade kelas tiket** (Economy → Business → Executive)
- **Perhitungan harga otomatis** dengan pajak 11%
- **Validasi data** untuk memastikan integritas sistem
- **Tampilan terstruktur** dengan format box yang rapi

## Arsitektur Sistem
Tugas/Modul_2/Tugas_3/
- MainApp.java # Class utama aplikasi
- TicketData.java # Data transfer object (Record)
- TicketOperations.java # Interface operasi tiket
- TransportationTicket.java # Abstract class dasar
- TrainTicket.java # Implementasi tiket kereta

## Class Diagram (Simplified)
1. TransportationTicket (Abstract)
2. TrainTicket → implements TicketOperations
3. Uses TicketData (Record)


## Cara Menjalankan
### 1. Compile Program
```bash
# Compile semua file Java
javac Tugas/Modul_2/Tugas_3/*.java

