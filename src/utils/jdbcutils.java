package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcutils {
    private static DruidDataSource datasource;
    static
    {

        try {
            Properties properties=new Properties();
            InputStream inputstream = jdbcutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputstream);
            datasource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(datasource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

public static Connection getconnection()
{
    Connection conn=null;
    try {
        conn=datasource.getConnection();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}
    public static void close(Connection conn)
    {
if(conn!=null)
{
    try {
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    }
}
