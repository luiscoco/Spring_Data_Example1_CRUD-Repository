package com.luxoft.data.examples;

import com.luxoft.data.examples.model.Book;
import com.luxoft.data.examples.repositories.BookRepository;
import com.luxoft.data.examples.repositories.SaveOnlyBookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Bean
    public ApplicationRunner demo(BookRepository crudRepository,
                                  SaveOnlyBookRepository saveOnlyBookRepository) {
        return env ->
        {
            printTitle("Spring Data Example 1. CRUD Repository");
            printTitle("H2 CONSOLE: localhost:8080/h2-console" +
                    "\nJDBC URL: jdbc:h2:mem:./books");

            print("Saving 2 new books...");

            Book book1 = new Book("Effective Java",
                    "Joshua Bloch", LocalDate.of(2018, 1, 6));
            Book book2 = new Book("Head First Java, 2nd Edition",
                    "Kathy Sierra", LocalDate.of(2009, 5, 11));

            crudRepository.save(book1);
            saveOnlyBookRepository.save(book2);

            printTitle("Books In Storage");
            crudRepository.findAll().forEach(System.out::println);
        };
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public static void printTitle(String s) {
        System.out.println("\n=======================");
        System.out.println(s);
        System.out.println("=======================");
    }

}
