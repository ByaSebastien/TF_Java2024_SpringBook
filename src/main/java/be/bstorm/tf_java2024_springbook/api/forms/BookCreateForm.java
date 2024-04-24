package be.bstorm.tf_java2024_springbook.api.forms;


import be.bstorm.tf_java2024_springbook.domain.entities.Book;

public record BookCreateForm (String title, String description){

    public Book toEntity(){
        return new Book(this.title,this.description);
    }
}
