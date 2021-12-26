import dao.JDBCaoImp;
import entities.Products;
import helpers.JDBCHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello Magios!");

        //csvHelper csvhelper = new csvHelper();
        //csvhelper.reader();

        JDBCaoImp sql1 = new JDBCaoImp();

        System.out.println("Ingrese items:");
        ArrayList<Products> products = new ArrayList<>();
        Products ingreso = new Products("remera","gucci especial","XL"
                ,"rojo",24.0f,24,"aa");
        products.add(ingreso);
        sql1.setProducts(products);

        sql1.getProducts();

    }
}
