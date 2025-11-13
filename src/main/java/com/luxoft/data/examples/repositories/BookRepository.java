package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
