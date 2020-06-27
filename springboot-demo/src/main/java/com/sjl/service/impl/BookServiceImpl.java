package com.sjl.service.impl;

import com.sjl.entity.Book;
import com.sjl.dao.BookDao;
import com.sjl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author songjilong
 * @date 2020/6/25 17:14
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookRepository;

    /**
     * 查询全部
     *
     * @return 查询结果
     */
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 分页查询
     *
     * @param page 当前页码
     * @param size 每页个数
     * @return 分页查询结果
     */
    @Override
    public Page<Book> page(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    /**
     * 添加图书
     *
     * @param book 图书信息
     * @return 返回添加的图书信息
     */
    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    /**
     * 根据id删除
     * @param id 图书id
     */
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * 根据id查询
     * @param id 图书编号
     * @return 查询结果
     */
    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }
}
