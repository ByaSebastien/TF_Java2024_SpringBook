package be.bstorm.tf_java2024_springbook.api.dtos;

import be.bstorm.tf_java2024_springbook.domain.entities.Book;

import java.time.LocalDate;

public record BookDTO(
        Long id,
        String title,
        String description,

        LocalDate release
) {
    public static BookDTO fromEntity(Book b){
        return new BookDTO(b.getId(), b.getTitle(), b.getDescription(),b.getRelease());
    }
}
