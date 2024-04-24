package be.bstorm.tf_java2024_springbook.dal.repositories;

import be.bstorm.tf_java2024_springbook.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select count(b) > 0 from Book b where b.title ilike :title")
    boolean existsByTitle(String title);

    @Query("select b from Book b where b.title ilike :title")
    Optional<Book> findByTitle(@Param("title") String title);
}
