package Tugas.Modul_2.Tugas_1;

public class Doctor {
    private static final double BONUS_RATE = 0.08;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private double salary;
    private String specialization;

    // constructor
    public Doctor(String name, int id, double salary, String specialization) {
        this.setName(name);
        this.id = id;
        this.salary = salary;
        this.specialization = specialization;
    }

    public void applyBonus(){
        salary += calculateBonus();
        System.out.println("Bonus applied | New Salary : " + salary);
    }

    private double calculateBonus() {
        double bonus = salary * BONUS_RATE;
        return bonus;
    }

    public void printDetails() {
        System.out.println("Doctor ID: " + id);
        System.out.println("Name: " + getName());
        System.out.println("Specialization: " + specialization);
        System.out.println("Salary: $" + salary);
    }

    // Update specialization
    public void updateSpecialization(String newSpecialization) {
        specialization = newSpecialization;
        System.out.println("Specialization updated to: " + specialization);
    }
}
