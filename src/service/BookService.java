package service;

import pojo.Book;
import pojo.page;

import java.util.List;

public interface BookService {
    public void addbook(Book book);
    public void deletebookbyid(Integer id);
    public void updatebook(Book book);
    public Book querybyid(Integer id);
    public List<Book> querybooks();

    page<Book> page(int pageNo, int pageSize);

    page<Book> pagebyprice(int pageNo, int pageSize, int min, int max);
}
