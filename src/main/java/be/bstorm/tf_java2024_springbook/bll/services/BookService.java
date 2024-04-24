package be.bstorm.tf_java2024_springbook.bll.services;

import be.bstorm.tf_java2024_springbook.domain.entities.Book;

import java.util.List;

public interface BookService {

    Long create(Book book);
    Book findById(Long id);
    Book findByTitle(String title);
    List<Book> findAll();
    void update(Long id, Book book);
    void delete(Long id);
}
