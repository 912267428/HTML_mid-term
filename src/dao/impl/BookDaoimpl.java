package dao.impl;

import dao.BookDao;
import pojo.Book;

import java.util.List;

public class BookDaoimpl extends basedao implements BookDao {
    @Override
    public int addbook(Book book) {
        String sql="insert into t_book(name,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path());
    }

    @Override
    public int deletebyid(Integer id) {
    String sql="delete from t_book where id=?";
    return update(sql,id);
    }

    @Override
    public int updatebook(Book book) {
        String sql="update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";

        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book querybookbyid(Integer id) {
        String sql="select * from t_book where id=?";

        return queryforone(Book.class,sql,id);
    }

    @Override
    public List<Book> querybooks() {
        String sql="select * from t_book";
        return queryfolist(Book.class,sql);
    }

    @Override
    public Integer queryforcount() {
        String sql="select count(*) from t_book";
        Number count= (Number) queryforsinger(sql);
        return  count.intValue();
    }

    @Override
    public List<Book> queryforpageitems(int begin, int pageSize) {
        String sql="select * from t_book limit ?,?";

        return queryfolist(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer queryforcountbyprice(int min,int max) {
        String sql="select count(*) from t_book where price between ? and ?";
      Number count= (Number) queryforsinger(sql,min,max);
        return count.intValue();
    }

    @Override
    public List<Book> queryforpageitemsbyprice(int begin, int pageSize, int min, int max) {
        String sql="select * from t_book where price between ? and ? order by price limit ?,?";
        return queryfolist(Book.class,sql,min,max,begin,pageSize);
    }
}
