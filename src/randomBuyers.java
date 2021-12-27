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
        System.out.println(randomPair.right);
        ArrayList<Products> product = sql.searchProducts(randomPair.right);
        System.out.println("Nuevo pedido de "+randomPair.left+" "+product.get(0).getProduct_name());

        if(randomPair.left > product.get(0).getQuantity()){
            System.out.println("No contamos con tantos ejemplares. Pruebe de nuevo...");
        }else {
            System.out.println("Total: "+product.get(0).getPrice()*randomPair.left);
        }
    }

}
