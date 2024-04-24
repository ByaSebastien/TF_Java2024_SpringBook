package be.bstorm.tf_java2024_springbook.api.controllers;

import be.bstorm.tf_java2024_springbook.api.forms.BookCreateForm;
import be.bstorm.tf_java2024_springbook.bll.services.BookService;
import be.bstorm.tf_java2024_springbook.domain.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody BookCreateForm book) {

        Long id = bookService.create(book.toEntity());
        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id);
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);// Si DTO => mapping
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping(path = "/bytitle", params = "title")
    public ResponseEntity<Book> getByTitle(@RequestParam String title) {
        Book book = bookService.findByTitle(title);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody BookCreateForm book) {
        bookService.update(id, book.toEntity());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
