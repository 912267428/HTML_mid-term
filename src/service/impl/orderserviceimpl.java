package service.impl;

import dao.BookDao;
import dao.impl.BookDaoimpl;
import dao.impl.orderDaoimpl;
import dao.impl.orderItemDaoimpl;
import dao.orderDao;
import dao.orderItemDao;
import pojo.*;
import service.orderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class orderserviceimpl implements orderService {
    private orderDao orderDao=new orderDaoimpl();
private orderItemDao orderItemDao=new orderItemDaoimpl();
private BookDao bookDao=new BookDaoimpl();
    public String createorder(cart cart, Integer userid) {
        String orderid=System.currentTimeMillis()+""+userid;
        order order=new order(orderid,new Date(),cart.getTotalprice(),0,userid);
        orderDao.saveorder(order);
        for(Map.Entry<Integer, cartitem>entry:cart.getItems().entrySet())
        {
            cartitem cartitem=entry.getValue();
            orderItemDao.saveorderItem(new orderItem(orderid,cartitem.getName(),cartitem.getCount(),cartitem.getPrice(),cartitem.getTotalprice(),null));
            Book book=bookDao.querybookbyid(cartitem.getId());
            book.setSales(book.getSales()+cartitem.getCount());
            book.setStock(book.getStock()-cartitem.getCount());
            bookDao.updatebook(book);
        }
        cart.clear();
        return orderid;
    }

    @Override
    public List<order> queryorderbyid(Integer id) {
        List<order> list=orderDao.querbyid(id);
        return list;
    }
}
