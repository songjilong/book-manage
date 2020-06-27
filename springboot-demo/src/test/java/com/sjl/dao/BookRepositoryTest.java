package com.sjl.dao;

import com.sjl.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author songjilong
 * @date 2020/6/25 16:55
 */
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookDao bookRepository;

    @Test
    void findAll(){
        System.out.println(bookRepository.findAll());
    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("Java编程思想");
        book.setAuthor("Bruce Eckel");
        bookRepository.save(book);
    }

    @Test
    void findById(){
        Book book = bookRepository.findById(1L).get();
        System.out.println(book);
    }

    @Test
    void update(){
        Book book = new Book();
        book.setId(18L);
        book.setName("张三的书");
        book.setAuthor("张三");
        Book save = bookRepository.save(book);
        System.out.println(save);
    }

    @Test
    void deleteById(){
        bookRepository.deleteById(17L);
    }
}