package test;

import com.alibaba.druid.util.JdbcUtils;
import org.junit.Test;
import utils.jdbcutils;

public class jdbcutilstest {
    @Test
    public void testjdbcutistest()
    {
        for(int i=0;i<10;i++) {
            System.out.println(jdbcutils.getconnection());
        }
    }
}
