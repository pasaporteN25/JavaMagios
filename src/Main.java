import dao.JDBCaoImp;
import entities.Products;
import helpers.JDBCHelper;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //csvHelper csvhelper = new csvHelper();
        //csvhelper.reader();

        JDBCaoImp sql1 = new JDBCaoImp();
        Scanner in = new Scanner(System.in);
        cui consola = new cui();

        //Inicio:
        consola.welcomeScreen();
        //Tengo que mejorar el switch, no deberia estar aca y las opciones se deberian modificar

        System.out.println("Nuevo pedido! ");
        randomBuyers compra1 = new randomBuyers();
        System.out.println(compra1.pedidoRopa());
        System.out.println("Item quantity: "+compra1.pedidoRopa().left
                +" | Item id: "+compra1.pedidoRopa().right);

        //Aca cuando entra un pedido hay que modificar el stock de una!! E informarlo


        //DB operations:
//        sql1.updateProduct("product_name","gucci 2C",1);
    }
}
