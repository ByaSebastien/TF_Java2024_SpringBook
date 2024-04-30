package be.bstorm.tf_java2024_springbook.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "RELEASE",nullable = true)
    private LocalDate release;

    public Book(String title, String description, LocalDate release) {
        this.title = title;
        this.description = description;
        this.release = release;
    }
}
