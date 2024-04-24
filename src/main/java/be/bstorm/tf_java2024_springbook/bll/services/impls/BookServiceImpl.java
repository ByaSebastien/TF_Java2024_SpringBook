package be.bstorm.tf_java2024_springbook.bll.services.impls;

import be.bstorm.tf_java2024_springbook.bll.services.BookService;
import be.bstorm.tf_java2024_springbook.dal.repositories.BookRepository;
import be.bstorm.tf_java2024_springbook.domain.entities.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

//    public BookServiceImpl(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @Override
    public Long create(Book book) {
        if(bookRepository.existsByTitle(book.getTitle())){
            throw new RuntimeException("Book already exists by title");
        }
        return bookRepository.save(book).getId();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void update(Long id, Book book) {
        Book bookToUpdate = findById(id);
        if(bookRepository.existsByTitle(book.getTitle())){
            throw new RuntimeException("Book already exists by title");
        }
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setDescription(book.getDescription());
        bookRepository.save(bookToUpdate);
    }

    @Override
    public void delete(Long id) {
        if(!bookRepository.existsById(id)){
            throw new RuntimeException("Book not found");
        }
        bookRepository.deleteById(id);
    }
}
