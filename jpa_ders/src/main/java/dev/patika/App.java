package dev.patika;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


//        //Supplier Ekleme
//        transaction.begin();
//        Supplier supplier = new Supplier();
//        supplier.setAddress("İstanbul/Beşiktaş");
//        supplier.setCompany("Patika");
//        supplier.setContact("0215352121");
//        supplier.setMail("info@mail.com");
//        supplier.setPerson("İsmet Onur Şahin");
//        entityManager.persist(supplier);
//        transaction.commit();
//
//        //Category Ekleme
//        transaction.begin();
//        Category category = new Category();
//        category.setName("Telefonlar");
//        entityManager.persist(category);
//        transaction.commit();
//
//        // Code Ekleme
//        transaction.begin();
//        Code code = new Code();
//        code.setGroup("12125");
//        code.setSerial("454545");
//        entityManager.persist(code);
//        transaction.commit();
//
//        // Product Ekleme
//        transaction.begin();
//        Product product = new Product();
//        product.setName("IPhone 15 Pro MAX");
//        product.setPrice(85000);
//        product.setStock(100);
//        product.setCode(code);
//        product.setSupplier(supplier);
//        product.setCategory(category);
//        entityManager.persist(product);
//        transaction.commit();

        // Color Ekleme
        transaction.begin();
        Color blue = new Color("blue");
        Color yellow = new Color("yellow");
        Color red = new Color("red");

        entityManager.persist(blue);
        entityManager.persist(yellow);
        entityManager.persist(red);

        Product product = entityManager.find(Product.class,1);
        List<Color> colorList = new ArrayList<>();
        colorList.add(blue);
        colorList.add(red);
        product.setColorList(colorList);
        transaction.commit();

    }
}