package com.sjl.dao;

import com.sjl.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author songjilong
 * @date 2020/6/25 16:52
 */
public interface BookDao extends JpaRepository<Book, Long> {
}
