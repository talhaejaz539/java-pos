package com.zbhg.mcp.pointofsale.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
    Connection con;
    String jdbcUrl = "jdbc:mysql://127.0.0.1/pointofsale";
    String driver = "com.mysql.cj.jdbc.Driver";

    public Utilities() throws SQLException, ClassNotFoundException {
        establishConnection();
    }

    private void establishConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        this.con = DriverManager.getConnection(jdbcUrl, "root", "root123");
    }

    public Connection getConnection() {
        return this.con;
    }

    public void closeConnection() throws SQLException{
        this.con.close();
    }

}
