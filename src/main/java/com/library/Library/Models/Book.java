package com.library.Library.Models;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name="mybooks")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")

    //Kolonat
    @Column(name = "ID")
    private int ID;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Author")
    private String Author;

    @Column(name = "Category")
    private String Category;

    @Column(name = "Publisher")
    private String Publisher;

    @Column(name = "Language")
    private String Language;

    @Column(name = "Price")
    private int Price;

    //Konstruktori
    public  Book(){
    }

    //Getters and Setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID(){
        return ID;
    }

    public void setTitle(String Title){
        this.Title = Title;
    }

    public String getTitle() {
        return Title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getAuthor() {
        return Author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        this.Publisher = publisher;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        this.Language = language;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    @Override
    public String toString(){
        return "myBooks{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Category='" + Category + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", Language='" + Language + '\'' +
                ", Price=" + Price +
                '}';
    }
}
