import dao.JDBCaoImp;
import entities.Products;
import helpers.JDBCHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello Magios!");

        //csvHelper csvhelper = new csvHelper();
        //csvhelper.reader();

        JDBCaoImp sql1 = new JDBCaoImp();

        System.out.println("Ingrese items:");
/*        ArrayList<Products> products = new ArrayList<>();
        Products ingreso = new Products("remera","gucci especial","L"
                ,"rojo",24.0f,24,"aa");
        Products ingreso2 = new Products("pantalon","prada","L"
                ,"jean",240.0f,60,"aa");

        products.add(ingreso);
        products.add(ingreso2);
        sql1.setProducts(products);
*/
        Scanner in = new Scanner(System.in);
        cui consola = new cui();
        consola.welcomeScreen();
        String option = in.nextLine();
        switch (option){
            case "1": consola.dbScreen(); break;
            case "2": consola.csvScreen(); break;
            case "3": System.out.println("Espera..."); break;
            case "4": System.out.println("Segui esperando.."); break;
            case "5": break;
        }
        //Tengo que mejorar el switch, no deberia estar aca y las opciones se deberian modificar

        randomBuyers compra1 = new randomBuyers();
        System.out.println(compra1.pedidoRopa());
        System.out.println(compra1.pedidoRopa());

        //DB operations:
//        sql1.getProducts();

//        sql1.updateProduct("product_name","gucci 2C",1);

//        sql1.getProducts();
    }
}
