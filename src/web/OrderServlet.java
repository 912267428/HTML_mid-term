package web;

import dao.impl.orderDaoimpl;
import dao.impl.orderItemDaoimpl;
import dao.orderDao;
import dao.orderItemDao;
import pojo.cart;
import pojo.order;
import pojo.user;
import service.impl.orderserviceimpl;
import service.orderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
private orderService orderService=new orderserviceimpl();
    protected void createorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cart cart= (pojo.cart) request.getSession().getAttribute("cart");
        user loguser= (user) request.getSession().getAttribute("user");

       if(loguser==null)
       {
request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
return;
       }
        Integer userid=loguser.getId();
        String orderid=orderService.createorder(cart,userid);
        request.getSession().setAttribute("orderid",orderid);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
    protected void showorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
           user user= (pojo.user) request.getSession().getAttribute("user");
          Integer id=user.getId();
            List<order> list=orderService.queryorderbyid(id);
            request.setAttribute("order",list);
            request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
        }
    }
}
