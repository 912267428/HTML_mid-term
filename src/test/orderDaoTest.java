package test;

import dao.impl.orderDaoimpl;
import dao.impl.orderItemDaoimpl;
import dao.orderDao;
import dao.orderItemDao;
import org.junit.Test;
import pojo.order;
import pojo.orderItem;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class orderDaoTest {
    @Test
    public  void saveorder()
    {
        orderDao orderDao=new orderDaoimpl();
        order order=new order("123456789555",new Date(),new BigDecimal(9.0),0,1);
        orderDao.saveorder(order);
    }
@Test
    public void saveorderitem()
{
    orderItemDao orderItemDao=new orderItemDaoimpl();
    orderItemDao.saveorderItem(new orderItem("123456789","java",1,new BigDecimal(50),new BigDecimal(50),null));
}
@Test
public void testlist()
{
    orderDao orderDao=new orderDaoimpl();
    List<order> list=orderDao.querbyid(7);
    for (order order : list) {
        System.out.println(order.toString());
    }

}
}