package dao.impl;

import dao.orderItemDao;
import pojo.orderItem;

public class orderItemDaoimpl extends basedao implements orderItemDao {
    @Override
    public int saveorderItem(orderItem orderItem) {
    String sql="insert into t_order_item(name,count,price,totalPrice,orderId) values(?,?,?,?,?)";

        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());

    }

}
