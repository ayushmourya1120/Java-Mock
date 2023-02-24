//DO NOT EDIT OR ADD ANY CODE HERE

package com.model;

import java.util.Date;

public class Book {
    private int bookId;
    private String department;
    private String bookName;
    private String bookAuthor;
    private double price;
    private String edition;
    private String publisher;
    private Date dateOfPurchase;

    public Book() {
        super();
    }

    public Book(int bookId, String department, String bookName, String bookAuthor, double price, String edition,
                String publisher, Date dateOfPurchase) {
        super();
        this.bookId = bookId;
        this.department = department;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.price = price;
        this.edition = edition;
        this.publisher = publisher;
        this.dateOfPurchase = dateOfPurchase;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }
}