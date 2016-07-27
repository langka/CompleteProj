package com.example.lenovo.completeproj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/7/25.
 */
public final class BookData {
    public static List<Book> initialBooks(){
        List<Book> bookList=new ArrayList<Book>();
        bookList.add(new Book(1,"Math1","THIS IS MATH1"));
        bookList.add(new Book(1,"Math2","THIS IS MATH2"));
        bookList.add(new Book(1,"Math3","THIS IS MATH3"));
        bookList.add(new Book(2,"Englishh1","THIS IS English1"));
        bookList.add(new Book(2,"Englishh2","THIS IS English2"));
        bookList.add(new Book(2,"Englishh3","THIS IS English3"));
        bookList.add(new Book(3,"Physics1","THIS IS phy1"));
        bookList.add(new Book(3,"Physics2","THIS IS phy2"));
        bookList.add(new Book(3,"Physics3","THIS IS phy3"));
        return bookList;
    }
}
class Book {
    String name;
    int category;
    String content;

    public Book() {
        name = "null";
        category = 0;
        content = "null";
    }

    public Book(int category, String content, String name) {
        this.category = category;
        this.content = content;
        this.name = name;
    }
}