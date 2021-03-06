package com.learnyeai.lucene.build;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zpz on 2018/9/6.
 */
public class DBUtil {

    private String url;
    private String user;
    private String password;
    private Connection conn;

    public DBUtil(String url,String user,String password) {
        this.url=url;
        this.user=user;
        this.password=password;
    }

    /**
     * 返回一个数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            if(conn==null)
                conn= DriverManager.getConnection(url,user,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *关闭数据库连接
     */
    public void closeConnection(){
        try {
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
          conn=null;
        }
    }
}
