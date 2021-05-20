package service;

import pojo.cart;
import pojo.order;

import java.util.List;

public interface orderService {
    public String createorder(cart cart,Integer userid);


    List<order> queryorderbyid(Integer id);
}
