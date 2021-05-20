package pojo;

import java.math.BigDecimal;

public class cartitem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalprice;

    public cartitem() {
    }

    public cartitem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalprice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalprice = totalprice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "cartitem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalprice=" + totalprice +
                '}';
    }
}
