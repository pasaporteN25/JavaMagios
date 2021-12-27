import dao.JDBCHelper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //csvHelper csvhelper = new csvHelper();
        //csvhelper.reader();

        JDBCHelper sql1 = new JDBCHelper();
        Scanner in = new Scanner(System.in);
        cui consola = new cui();

        //Inicio:
        //consola.welcomeScreen();
        //Tengo que mejorar el switch, no deberia estar aca y las opciones se deberian modificar

        System.out.println("Nuevo pedido! ");
        randomBuyers compra1 = new randomBuyers();
        compra1.verifyBuy();
        //Aca cuando entra un pedido hay que modificar el stock de una!! E informarlo


        //DB operations:
//        sql1.updateProduct("product_name","gucci 2C",1);
    }
}
