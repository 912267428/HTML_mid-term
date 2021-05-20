package dao;

import pojo.order;

import java.util.List;

public interface orderDao {
    public int saveorder(order order);

    List<order> querbyid(Integer id);

}
