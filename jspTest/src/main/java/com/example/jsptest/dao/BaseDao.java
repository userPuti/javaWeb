package com.example.jsptest.dao;

import com.example.jsptest.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author puti
 * @date 2022/3/18
 */
public abstract class BaseDao {
    //使用Dbutils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行对数据库的更新操作
     *
     * @param sql  sql语句
     * @param args sql语句的参数
     * @return 影响的行数
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            int num = queryRunner.update(connection, sql, args);
            connection.commit();
            return num;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回对象的类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return 查询到结果则返回，否则返回null
     */
    public <T> Object queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }


    /**
     * 批量查询
     *
     * @param type 查询的数据类型
     * @param sql  sql语句
     * @param args sql语句中的参数
     * @param <T>  查询提供的类型
     * @return List<T>
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询单个值
     *
     * @param sql  sql语句
     * @param args sql语句需要的参数
     * @return Object
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}


