package dao;

import com.google.protobuf.Any;
import entities.Products;
import helpers.JDBCHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    public void setProducts(ArrayList<Products> dataIn){
        //quiza pueda retornar un boolean
        try(Connection conn = JDBCHelper.getConnection();
            Statement st = conn.createStatement()){

            for (Products product : dataIn){
                String sql= "INSERT INTO products(" +
                        "product_type,product_name,size,colour,price,quantity,description" +
                        ") VALUES ('" +
                        product.getProduct_type() + "', '" +
                        product.getProduct_name() + "', '" +
                        product.getSize() + "', '" +
                        product.getColour() + "', " +
                        product.getPrice() + ", " +
                        product.getQuantity() + ", '" +
                        product.getDescription() + "')";

                st.executeUpdate(sql);
                System.out.println("Insertado con exito!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void searchProducts(){

    }

    public void updateProduct(String campo, Object valor, Integer id){
        String sqlUpdate = "UPDATE products SET "+ campo + " = '" + valor + "' WHERE product_ID = " + id;
        try(Connection conn = JDBCHelper.getConnection();
            Statement st = conn.createStatement()) {
            st.executeUpdate(sqlUpdate);
            System.out.println("Update Successfull");
        }catch (SQLException e ){
            e.printStackTrace();
        }

        }

    public void deleteProduct(){

    }
}
