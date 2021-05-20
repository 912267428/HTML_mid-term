package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.jdbcutils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class basedao {
    private QueryRunner queryRunner=new QueryRunner();

    /**
     *
     * @return
     */
    public int update(String sql,Object ...args)  {
        Connection con= jdbcutils.getconnection();
        try {
            return queryRunner.update(con,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }
    public <T> T queryforone(Class<T> type, String sql,Object ...args) {
        Connection con= jdbcutils.getconnection();
        try {
           return queryRunner.query(con,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     *
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> List<T> queryfolist(Class<T> type,String sql,Object ...args)  {
    Connection con= jdbcutils.getconnection();
    try {
        return queryRunner.query(con,sql,new BeanListHandler<T>(type),args);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return  null;
}
public Object queryforsinger(String sql,Object ...args) {
    Connection con= jdbcutils.getconnection();
    try {
     return queryRunner.query(con,sql,new ScalarHandler(),args);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    finally {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    return null;
}
}
