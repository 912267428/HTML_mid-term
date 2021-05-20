package web;

import pojo.Book;
import pojo.cart;
import pojo.cartitem;
import service.BookService;
import service.impl.BookServiceimpl;
import utils.Webutils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("加入购物车");
        //System.out.println(request.getParameter("id"));
        String url=request.getHeader("Referer");
        int id= Webutils.parseint(request.getParameter("id"),0);
        BookService bookService=new BookServiceimpl();
        Book book=bookService.querybyid(id);
        cartitem cartitem=new cartitem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        cart cart= (pojo.cart) request.getSession().getAttribute("cart");
        if(cart==null)
        {
            cart=new cart();
            request.getSession().setAttribute("cart",cart);
        }
        cart.additem(cartitem);
        System.out.println(cart);
response.sendRedirect(url);
request.getSession().setAttribute("lastname",cartitem.getName());
    }
    protected void deleteitem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
int id=Webutils.parseint(request.getParameter("id"),0);
        cart cart = (pojo.cart) request.getSession().getAttribute("cart");
if(cart!=null)
{
    cart.delete(id);
    response.sendRedirect(request.getHeader("Referer"));
}
    }
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        cart cart = (pojo.cart) request.getSession().getAttribute("cart");
        if(cart!=null)
        {
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id=Webutils.parseint(request.getParameter("id"),0);
        int count=Webutils.parseint(request.getParameter("count"),0);
        cart cart = (pojo.cart) request.getSession().getAttribute("cart");
        if(cart!=null)
        {
            cart.update(id,count);
            response.sendRedirect(request.getHeader("Referer"));

        }
    }
}
