package web;

import pojo.Book;
import pojo.page;
import service.BookService;
import service.impl.BookServiceimpl;
import utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService=new BookServiceimpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> list = bookService.querybooks();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

    {
        Book book= Webutils.copytobean(request.getParameterMap(),new Book());
        bookService.addbook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookservlet?action=page&pageNo="+request.getParameter("pageNo"));


    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       String id=request.getParameter("id");
       bookService.deletebookbyid(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath()+"/manager/bookservlet?action=page&pageNo="+request.getParameter("pageNo"));

    }
    protected void getbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id=request.getParameter("id");
        Book book=bookService.querybyid(Integer.parseInt(id));
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo="+request.getParameter("pageNo")).forward(request,response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
Book book=Webutils.copytobean(request.getParameterMap(),new Book());
book.setId(Integer.parseInt(request.getParameter("id")));
bookService.updatebook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookservlet?action=page&pageNo="+request.getParameter("pageNo"));
    }
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
int pageNo=Webutils.parseint(request.getParameter("pageNo"),1);
int pageSize=Webutils.parseint(request.getParameter("pageSize"), page.PAGE_SIZE);
page<Book> page=bookService.page(pageNo,pageSize);
page.setUrl("manager/bookservlet?action=page");
request.setAttribute("page",page);
request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
