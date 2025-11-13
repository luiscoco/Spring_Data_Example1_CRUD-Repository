package com.luxoft.data.examples.repositories;

import com.luxoft.data.examples.model.Book;
import org.springframework.data.repository.Repository;

public interface SaveOnlyBookRepository extends Repository<Book, Long> {
    Book save(Book entity);
}
