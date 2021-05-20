package dao;

import pojo.Book;

import java.awt.*;
import java.util.List;

public interface BookDao {
    public int addbook(Book book);
    public int deletebyid(Integer id);
    public int updatebook(Book book);
    public Book querybookbyid(Integer id);
    public List<Book> querybooks();

    Integer queryforcount();

    List<Book> queryforpageitems(int begin, int pageSize);

    Integer queryforcountbyprice(int min,int max);

    List<Book> queryforpageitemsbyprice(int begin, int pageSize, int min, int max);
}
