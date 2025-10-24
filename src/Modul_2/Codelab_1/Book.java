package Modul_2.Codelab_1;

public class Book {
    public static final double DISCOUNT_RATE = 0.1;
    private String title;
    private String author;
    private double price;
    private int stock;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Constructor
    Book(String title, String author, double price, int stock) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
        this.setStock(stock);
    }

    // Display book details
    public void displayInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + getAuthor());
        System.out.println("Price: $" + getPrice());
        System.out.println("Discounted Price $" + calculationDiscount());
        System.out.println("Stock: " + getStock());
    }

    private double calculationDiscount() {
        return getPrice() - (getPrice() * DISCOUNT_RATE);
    }

    // Adjust the book stock
    public void adjustStock(int adjustment) {
        setStock(getStock() + adjustment);
        System.out.println("Stock adjusted.");
        System.out.println("Current: " + getStock());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
