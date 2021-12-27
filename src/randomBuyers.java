import com.mysql.cj.conf.ConnectionUrlParser;
import helpers.JDBCHelper;
import entities.Products;

import java.util.ArrayList;

public class randomBuyers {
    //log.info log.error

    //Deberia elegir un numero de id, sacarlo del csv y enviarlo a la db
    //O minimamente devolverlo al main y que ahi se mande a la db
    //Esta pasa a privado en breve
    public ConnectionUrlParser.Pair<Integer, Integer> pedidoRopa(){

        //Calcular también cuanto stock queda y cuanto hay que reponer para volver al estado inicial
        //Total del pedido:
        int totalRand = (int) (Math.random() * ((30-1) +1));

        //Id del producto requerido:
        int idRand = (int) (Math.random() * (1259-1)+1);

        return new ConnectionUrlParser.Pair<>(totalRand,idRand);
    }

    //Tengo que crear un nuevo objeto de respuesta para el cliente, la idea seria escupirlo en json...
    public void verifyBuy(){

        ConnectionUrlParser.Pair<Integer,Integer> randomPair = pedidoRopa();
        JDBCHelper sql = new JDBCHelper();
        ArrayList<Products> products = sql.searchProducts(randomPair.right);
        Products product = products.get(0);

        System.out.println("Nuevo pedido de "+randomPair.left+" "+product.getProduct_name());
        System.out.println("Stock actual: "+product.getQuantity());

        if(randomPair.left > product.getQuantity()){
            System.out.println("No contamos con tantos ejemplares. Pruebe de nuevo...");
        }else {
            sql.updateProduct("quantity",(product.getQuantity()-randomPair.left),product.getProduct_ID());
            System.out.println("Total a pagar: "+product.getPrice()*randomPair.left);
            ArrayList<Products> newProducts = sql.searchProducts(randomPair.right);
            System.out.println("Nuevo stock: "+newProducts.get(0).getQuantity());
            System.out.println("---------------------------------");
        }
    }

}
