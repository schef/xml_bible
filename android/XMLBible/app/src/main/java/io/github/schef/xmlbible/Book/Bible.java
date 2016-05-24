package io.github.schef.xmlbible.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schef on 5/24/16.
 */
public class Bible {

    //singleton instance start
    private static Bible instance;

    public static Bible getInstance() {
        if (instance == null)
            instance = new Bible();
        return instance;
    }

    private Bible() {}
    //singleton instance end

    String name;
    List<Book> books;

    public void init(String name){
        this.name = name;
        this.books = new ArrayList<Book>();
        System.out.println("bible added");
    }

    public Book addBook(){
        Book book = new Book();
        books.add(book);
        return book;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Integer getSize(){
        return books.size();
    }

    public Book getBook(int position){
        return books.get(position);
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.name;
    }

}
