package dao;

import entities.Products;
import helpers.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCaoImp {

    public Products getProducts(){
        Products products = new Products();

        try (Connection conn = JDBCHelper.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products")) {

            while (rs.next()){
                System.out.println("ID: " + rs.getInt("product_ID"));
                System.out.println("Nombre: " + rs.getString("product_name"));
                products.setProduct_ID(rs.getInt("product_ID"));
                products.setProduct_name(rs.getString("product_name"));
            }


        }catch (SQLException e ){
            e.printStackTrace();
        }
        return products;
    }
}
