package com.zdk.jbdc.web;

import com.zdk.jbdc.entity.BookEntity;
import com.zdk.jbdc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/read")
    public List<BookEntity> readBook(){
        List<BookEntity>  list = bookRepository.findAll();

        return  list;
    }
}
