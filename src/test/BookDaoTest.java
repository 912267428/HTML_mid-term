package test;

import dao.BookDao;
import dao.impl.BookDaoimpl;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
private BookDao dao=new BookDaoimpl();
    @Test
    public void addbook() {
        Book b1=new Book(null,"欧阳","ouyang",new BigDecimal(18.2),999,9,"static/img/default.jpg");
        System.out.println(dao.addbook(b1));
    }

    @Test
    public void deletebyid() {
        System.out.println(dao.deletebyid(15));
    }

    @Test
    public void updatebook() {
        Book b1=new Book(1,"欧阳","ouyang",new BigDecimal(18.2),999,9,"static/img/default.jpg");
        System.out.println(dao.updatebook(b1));
    }

    @Test
    public void querybookbyid() {
    }

    @Test
    public void querybooks() {
        List<Book> list=dao.querybooks();
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testcount()
    {
        System.out.println(dao.queryforcount());
    }
    @Test
    public void testitems()
    {
        for (Book book : dao.queryforpageitems(8, 4)) {
            System.out.println(book.toString());
        }

    }
}