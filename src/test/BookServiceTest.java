package test;

import com.alibaba.druid.pool.vendor.SybaseExceptionSorter;
import org.junit.After;
import org.junit.Test;
import service.BookService;
import service.impl.BookServiceimpl;

import static org.junit.Assert.*;

public class BookServiceTest {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void page() {
        BookService bookService=new BookServiceimpl();
        System.out.println(bookService.page(1,4).toString());
    }
    @Test
    public void pagebyprice()
    {
        BookService bookService=new BookServiceimpl();
        System.out.println(bookService.pagebyprice(1,4,0,50));
    }
}