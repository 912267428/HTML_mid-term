package service.impl;

import dao.BookDao;
import dao.impl.BookDaoimpl;
import pojo.Book;
import pojo.page;
import service.BookService;

import java.util.List;

public class BookServiceimpl implements BookService {
    private BookDao dao=new BookDaoimpl();
    @Override
    public void addbook(Book book) {
        dao.addbook(book);
    }

    @Override
    public void deletebookbyid(Integer id) {
dao.deletebyid(id);
    }

    @Override
    public void updatebook(Book book) {
dao.updatebook(book);
    }

    @Override
    public Book querybyid(Integer id) {
        return dao.querybookbyid(id);
    }

    @Override
    public List<Book> querybooks() {
        return dao.querybooks();
    }

    @Override
    public page<Book> page(int pageNo, int pageSize) {
        page<Book> page=new page<Book>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pagetotailcount=dao.queryforcount();
        page.setPageTotalCount(pagetotailcount);
        Integer pagetotail=pagetotailcount/pageSize;
        if(pagetotailcount%pageSize>0)
        {
            pagetotail=pagetotail+1;
        }
        page.setPageTotal(pagetotail);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=dao.queryforpageitems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public page<Book> pagebyprice(int pageNo, int pageSize, int min, int max) {
        page<Book> page=new page<Book>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Integer pagetotailcount=dao.queryforcountbyprice(min,max);
        page.setPageTotalCount(pagetotailcount);
        Integer pagetotail=pagetotailcount/pageSize;
        if(pagetotailcount%pageSize>0)
        {
            pagetotail=pagetotail+1;
        }
        page.setPageTotal(pagetotail);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=dao.queryforpageitemsbyprice(begin,pageSize,min,max);
        page.setItems(items);
        return page;

    }
}
