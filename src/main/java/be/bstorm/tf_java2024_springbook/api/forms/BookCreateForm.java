package be.bstorm.tf_java2024_springbook.api.forms;


import be.bstorm.tf_java2024_springbook.api.Validators.BeforeToday;
import be.bstorm.tf_java2024_springbook.domain.entities.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BookCreateForm (
        @NotBlank
        @Size(min = 5,max = 100)
        String title,

        @Size(max = 500)
        @Pattern(regexp = "^[A-Za-z]+$")
        String description,

        @BeforeToday
        LocalDate release
){

    public Book toEntity(){
        return new Book(this.title,this.description,this.release);
    }
}
