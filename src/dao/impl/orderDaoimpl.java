package dao.impl;

import dao.orderDao;
import pojo.order;

import java.util.List;

public class orderDaoimpl extends  basedao implements orderDao  {
    @Override
    public int saveorder(order order) {
        String sql="insert into t_order(orderId,createTime,price,status,userId) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());

    }

    @Override
    public List<order> querbyid(Integer id) {
        String sql="select * from t_order where userId=?";

        return queryfolist(order.class,sql,id);
    }


}
