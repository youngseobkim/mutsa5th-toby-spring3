package com.example.mutsa5thtobyspring3.db;

import java.sql.*;

public class ConnectionChecker {
    public void check() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://ec2-54-180-80-75.ap-northeast-2.compute.amazonaws.com/spring-db",
                "root", "password");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SHOW DATABASES");
        rs = st.getResultSet();
        
        while (rs.next()) {
            String str = rs.getString(1);
            System.out.println(str);
        }
    }

    public void add() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://ec2-54-180-80-75.ap-northeast-2.compute.amazonaws.com/spring-db",
                "root", "password");

        PreparedStatement pstmt = con.prepareStatement("insert into users(id, name, password) values(?, ?, ?)");
        pstmt.setString(1, "1");
        pstmt.setString(2, "kys ");
        pstmt.setString(3, "12345678");
        pstmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionChecker cc = new ConnectionChecker();
        cc.add();
    }
}