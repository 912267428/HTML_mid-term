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

public class ClientBookServlet extends BaseServlet {
    private BookService bookService=new BookServiceimpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int pageNo= Webutils.parseint(request.getParameter("pageNo"),1);
        int pageSize=Webutils.parseint(request.getParameter("pageSize"), page.PAGE_SIZE);
        page<Book> page=bookService.page(pageNo,pageSize);
        page.setUrl("clientBookServlet?action=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
    protected void pagebyprice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int pageNo= Webutils.parseint(request.getParameter("pageNo"),1);
        int pageSize=Webutils.parseint(request.getParameter("pageSize"), page.PAGE_SIZE);
        int min=Webutils.parseint(request.getParameter("min"),0);
        int max=Webutils.parseint(request.getParameter("max"),Integer.MAX_VALUE);
        page<Book> page=bookService.pagebyprice(pageNo,pageSize,min,max);
        page.setUrl("clientBookServlet?action=pagebyprice");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
