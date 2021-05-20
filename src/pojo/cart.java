package pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class cart {
   // private Integer totalcount;
   // private BigDecimal totalprice;
    private Map<Integer,cartitem> items=new LinkedHashMap<Integer, cartitem>();

    public cart() {
    }

    public cart(Integer totalcount, BigDecimal totalprice, Map<Integer, cartitem> items) {

        this.items = items;
    }

    public Integer getTotalcount() {
        Integer totalcount=0;
        for(Map.Entry<Integer,cartitem> entry: items.entrySet())
        {
        totalcount=totalcount+entry.getValue().getCount();
        }
        return totalcount;
    }



    public BigDecimal getTotalprice() {
        BigDecimal totalprice=new BigDecimal(0);
        for(Map.Entry<Integer,cartitem> entry: items.entrySet())
        {
            totalprice=totalprice.add(entry.getValue().getTotalprice());
        }
        return totalprice;
    }



    public Map<Integer, cartitem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, cartitem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "cart{" +
                "totalcount=" + getTotalcount() +
                ", totalprice=" + getTotalprice() +
                ", items=" + items +
                '}';
    }
    public void additem(cartitem cartitem)
    {
        pojo.cartitem cartitem1 = items.get(cartitem.getId());
        if(cartitem1==null)
        {
            items.put(cartitem.getId(),cartitem);
        }
        else {
            cartitem1.setCount(cartitem1.getCount()+1);
            cartitem1.setTotalprice(cartitem1.getPrice().multiply(new BigDecimal(cartitem1.getCount())));
        }
    }
    public void delete(Integer id)
    {
        items.remove(id);
    }
    public void clear()
    {
        items.clear();
    }
    public  void update(Integer id,Integer count)
    {
        cartitem cartitem = items.get(id);
        if(cartitem!=null)
        {
            cartitem.setCount(count);
            cartitem.setTotalprice(cartitem.getPrice().multiply(new BigDecimal(cartitem.getCount())));
        }
    }
}
