package com.assignment1.LibraryInfoDisplay.service;

import com.assignment1.LibraryInfoDisplay.model.Book;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {

    public List<Book> readBooks() {

        List<Book> books = new ArrayList<>();

        try {

            ClassPathResource resource =
                    new ClassPathResource("books_catalog.csv");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(resource.getInputStream()));

            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Book book = new Book();

                book.setId(Integer.parseInt(data[0]));
                book.setBookName(data[1]);
                book.setAuthorName(data[2]);
                book.setCategory(data[3]);
                book.setPublisher(data[4]);
                book.setPrice(Double.parseDouble(data[5]));
                book.setQuantity(Integer.parseInt(data[6]));
                book.setPublishedYear(Integer.parseInt(data[7]));
                book.setIsbn((long) Double.parseDouble(data[8]));
                book.setLanguage(data[9]);

                books.add(book);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        return books;
    }
    public Book readBookById(int id){
        List<Book> books = readBooks();

        for(Book book : books) {
            if(book.getId() == id) {
                return book;
            }
        }

    return null;
    }
    public Book readBookByAuthor(String authorName){
        List<Book> books = readBooks();
        for(Book book: books){
            if(book.getAuthorName().equals(authorName)){
                return book;
            }
        }
        return null;
    }
    public List<Book> readBooksByCategory(String category){
        List<Book> books = readBooks();
        List<Book> result = new ArrayList<>();
        for(Book book: books){
            if(book.getCategory().equals(category)){
                result.add(book);
            }
        }
        return result;
    }
}