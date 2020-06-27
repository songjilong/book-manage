package com.sjl.service;

import com.sjl.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author songjilong
 * @date 2020/6/25 17:13
 */
public interface BookService {
    /**
     * 查询全部
     *
     * @return 查询结果
     */
    List<Book> findAll();

    /**
     * 分页查询
     *
     * @param page 当前页码
     * @param size 每页个数
     * @return 分页查询结果
     */
    Page<Book> page(int page, int size);

    /**
     * 添加图书
     *
     * @param book 图书信息
     * @return 返回添加的图书信息
     */
    Book addBook(Book book);

    /**
     * 根据id删除
     * @param id 图书id
     */
    void deleteById(Long id);

    /**
     * 根据id查询
     * @param id 图书编号
     * @return 查询结果
     */
    Book findById(Long id);
}
