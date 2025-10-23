package Tugas.Modul_2.Tugas_1;

public class Main {
    public static class MainApp {
        public static void main(String[] args) {
            Doctor doctor = new Doctor("Dr. Sarah Lee", 2001, 10000, "Cardiology");
            Patient patient = new Patient("Michael Brown", 555, doctor, "Heart Disease");

            Hospital hospital = new Hospital("City General Hospital", "123 Main Street", patient);
            hospital.printHospitalDetails();

            System.out.println();
            doctor.applyBonus();
            doctor.printDetails();
        }
    }
}
