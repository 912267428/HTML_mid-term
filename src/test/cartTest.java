package test;

import org.junit.Test;
import pojo.cart;
import pojo.cartitem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class cartTest {

    @Test
    public void additem() {
        cart cart=new cart();
        cart.additem(new cartitem(1,"java",1,new BigDecimal(100),new BigDecimal(500)));
        cart.additem(new cartitem(1,"java",1,new BigDecimal(100),new BigDecimal(500)));
        cart.additem(new cartitem(1,"java",1,new BigDecimal(100),new BigDecimal(500)));
        cart.additem(new cartitem(2,"java se",1,new BigDecimal(100),new BigDecimal(500)));
        System.out.println(cart);

    }

    @Test
    public void delete() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void update() {
    }
}