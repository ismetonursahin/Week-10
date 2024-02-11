package com.kutuphane;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id" , columnDefinition = "serial")
    private int id;

    @Column(name = "book_name" , nullable = false)
    private String name;

    @Column(name = "book_publicationYear" , nullable = false)
    private String publicationYear;

    @Column(name = "book_stock" , nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "book_author_id" , referencedColumnName = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book2category",
            joinColumns = {
                    @JoinColumn(name = "book2category_book_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "book2category_category_id")
            }
    )
    private List<Category> categoryList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_publisher_id" , referencedColumnName = "publisher_id")
    private Publisher publisher;


    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<BookBorrowing> borrowingList;


    public Book() {
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookBorrowing> getBorrowingList() {
        return borrowingList;
    }

    public void setBorrowingList(List<BookBorrowing> borrowingList) {
        this.borrowingList = borrowingList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", stock=" + stock +
                ", author=" + author +
                ", publisher=" + publisher +
                ", borrowingList=" + borrowingList +
                ", categoryList=" + categoryList +
                '}';
    }
}
