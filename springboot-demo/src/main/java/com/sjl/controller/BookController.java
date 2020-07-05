package com.sjl.controller;

import com.sjl.entity.Book;
import com.sjl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author songjilong
 * @date 2020/6/25 17:12
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 查询所有
     *
     * @return 查询结果
     */
    @GetMapping("/findAll")
    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    /**
     * 分页查询
     *
     * @param page 当前页码
     * @param size 每页个数
     * @return 分页查询结果
     */
    @GetMapping("/page/{page}/{size}")
    public Page<Book> page(@PathVariable("page") int page,
                           @PathVariable("size") int size) {
        return bookService.page(page - 1, size);
    }

    /**
     * 添加图书
     *
     * @param book 图书信息
     * @return 返回信息
     */
    @PostMapping("/add")
    public String add(@RequestBody Book book) {
        Book result = bookService.addBook(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 更新图书
     *
     * @param book 图书信息
     * @return 返回信息
     */
    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookService.addBook(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 根据id删除
     *
     * @param id 图书id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
    }

    /**
     * 根据id查询
     *
     * @param id 图书编号
     * @return 查询结果
     */
    @GetMapping("/find/{id}")
    public Book findById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }
}
