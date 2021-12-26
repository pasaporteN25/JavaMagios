package dao;

import entities.Products;
import helpers.JDBCHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCaoImp {

    public Products products() throws SQLException {
        Products products = new Products();

        try {
            Connection conn = JDBCHelper.getConnection();
            String SQLSELECTALL = "SELECT * FROM products"
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
