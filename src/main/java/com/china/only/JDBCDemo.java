package com.china.only;

import java.sql.*;
/**
 * 测试一下事务回滚后还能提交新的sql吗?
 * */
public class JDBCDemo {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/sina";
    private static String username = "root";
    private static String password = "root";

    static {
        try {
        // 加载数据库驱动
            Class.forName(driver);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args){
        modifyData();
    }

    /**
     * 该例子说明事务rollback后还能提交新的sql
     * */

    public static void modifyData(){
        Connection conn = null;
        PreparedStatement st = null;
//        ResultSet rs = null;
        conn = getConnection();
        String sql1 = "insert into house (name, price) values(?,?)";
        try {
            conn.setAutoCommit(false);
            st = conn.prepareStatement(sql1);
            st.setString(1,"万科大厦");
            st.setDouble(2,16999);
            st.executeUpdate();
            conn.rollback();
            st = conn.prepareStatement(sql1);
            st.setString(1,"中南海");
            st.setDouble(2,1);
            st.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
