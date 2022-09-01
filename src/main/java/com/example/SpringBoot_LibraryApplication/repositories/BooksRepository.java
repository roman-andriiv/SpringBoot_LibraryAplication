package com.example.SpringBoot_LibraryApplication.repositories;


import com.example.SpringBoot_LibraryApplication.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Roman_Andriiv
 */
@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String title);

}
