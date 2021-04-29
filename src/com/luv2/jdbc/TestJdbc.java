package com.luv2.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args){
        Connection con1;
        PreparedStatement insert;
        //  jetbrains://idea/navigate/reference?project=connection&fqn=com.mysql.jdbc.Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/HyberNate", "root", "MaiMai1@3");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
