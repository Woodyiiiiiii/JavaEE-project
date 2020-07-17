package com.woody.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现线程的绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程的连接
     * @return
     */
    public Connection getThreadConnection() {
        try {
            // 1. 先从ThreadLocal上获取
            Connection connection = threadLocal.get();
            // 2. 判断当前线程上是否有连接
            if (connection == null) {
                // 3. 从数据源中获取一个连接，并存入Thread Local中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            // 4. 返回当前线程上的连接
            return connection;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }
}
