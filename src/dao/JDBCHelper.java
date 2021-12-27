package dao;

import entities.Customers;
import entities.Products;
import helpers.JDBCImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBCHelper {

    public ArrayList<Products> getProducts(){
        ArrayList<Products> prodList = new ArrayList<>();
        Products products = new Products();

        try (Connection conn = JDBCImp.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products")) {

            while (rs.next()){
                //Esto se va al cui
                System.out.println("ID: " + rs.getInt("product_ID"));
                System.out.println("Nombre: " + rs.getString("product_name"));
                //
                products.setProduct_ID(rs.getInt("product_ID"));
                products.setProduct_type(rs.getString("product_type"));
                products.setProduct_name(rs.getString("product_name"));
                products.setSize(rs.getString("size"));
                products.setColour(rs.getString("colour"));
                products.setPrice(rs.getFloat("price"));
                products.setQuantity(rs.getInt("quantity"));
                products.setDescription(rs.getString("description"));
                prodList.add(products);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return prodList;
    }

    public void setProducts(ArrayList<Products> dataIn){
        //quiza pueda retornar un boolean
        try(Connection conn = JDBCImp.getConnection();
            Statement st = conn.createStatement()){

            for (Products product : dataIn){
                String sql;
                sql = "INSERT INTO products(" +
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
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    //Podria buscar por otros parametros pero por ahora solo nombre
    public ArrayList<Products> searchProducts(Object paramSearch){

        String rowToSearch;
        //Tengo que modificarlo para traer por id!

        if(paramSearch instanceof String){
            rowToSearch="product_name";
        }else if (paramSearch instanceof Integer){
            rowToSearch="product_ID";
        }else {
            //Manejar si no es lo que espero!
            rowToSearch="";
        }
        ArrayList<Products> pList = new ArrayList<>();

        try (Connection conn = JDBCImp.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products WHERE '"+rowToSearch+"' LIKE'%"+paramSearch+"%'")) {

            while (rs.next()){
                Products productFind = new Products();
                productFind.setProduct_ID(rs.getInt("product_ID"));
                productFind.setProduct_type(rs.getString("product_type"));
                productFind.setProduct_name(rs.getString("product_name"));
                productFind.setSize(rs.getString("size"));
                productFind.setColour(rs.getString("colour"));
                productFind.setPrice(rs.getFloat("price"));
                productFind.setQuantity(rs.getInt("quantity"));
                productFind.setDescription(rs.getString("description"));

                pList.add(productFind);
            }
            if(pList.size() != 0){
                System.out.println("Coincidencias en la busqueda: "+pList.size());
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return pList;

    }

    public void updateProduct(String campo, Object valor, Integer id){
        String sqlUpdate = "UPDATE products SET "+ campo + " = '" + valor + "' WHERE product_ID = " + id;
        try(Connection conn = JDBCImp.getConnection();
            Statement st = conn.createStatement()) {
            st.executeUpdate(sqlUpdate);
            System.out.println("Update Successfull");
        }catch (SQLException e ){
            e.printStackTrace();
        }

        }

    public void deleteProduct(){

    }

    //customer_id,customer_name,gender,age,home_address,zip_code,city,state,country
    //
    //Customers:
    public ArrayList<Customers> getCustomers(){
        ArrayList<Customers> custList = new ArrayList<>();
        Customers customers = new Customers();

        try (Connection conn = JDBCImp.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM products")) {

            while (rs.next()){
                //Esto se deberia pasar al cui
                System.out.println("ID: " + rs.getInt("customer_id"));
                System.out.println("Nombre: " + rs.getString("customer_name"));
                //-----------
                customers.setCustomer_id(rs.getInt("customer_id"));
                customers.setCustomer_name(rs.getString("customer_name"));
                customers.setGender(rs.getString("gender"));
                customers.setAge(rs.getInt("age"));
                customers.setHome_address(rs.getString("home_address"));
                customers.setZip_code(rs.getInt("zip_code"));
                customers.setCustomer_name(rs.getString("city"));
                customers.setCustomer_name(rs.getString("state"));
                customers.setCustomer_name(rs.getString("country"));

                custList.add(customers);
            }

        }catch (SQLException e ){
            e.printStackTrace();
        }
        return custList;
    }

}
