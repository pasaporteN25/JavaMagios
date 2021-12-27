import com.mysql.cj.conf.ConnectionUrlParser;
import dao.JDBCHelper;
import entities.Products;

import java.util.ArrayList;

public class randomBuyers {
    //log.info log.error

    //Deberia elegir un numero de id, sacarlo del csv y enviarlo a la db
    //O minimamente devolverlo al main y que ahi se mande a la db
    //Esta pasa a privado en breve
    public ConnectionUrlParser.Pair<Integer, Integer> pedidoRopa(){

        //Este tiene que hacer una verificacion de stock!
        //Y aceptar o rechazar el pedido de acuerdo a eso
        //Pero no aca, aca solo se implementa, pero eso se tiene que hacer en un controlador central??
        //Afuera también imprimo cuanto cuesta todx el pedido
        //Calcular también cuanto stock queda y cuanto hay que reponer para volver al estado inicial
        //Total del pedido:
        int totalRand = (int) (Math.random() * ((30-1) +1));

        //Id del pedido:
        int idRand = (int) (Math.random() * (1259-1)+1);

        //El segundo parametro pasa a ser un objeto de tipo Product
        //probar si el get no toma 1...

        return new ConnectionUrlParser.Pair<>(totalRand,idRand);
    }

    //Tengo que crear un nuevo objeto de respuesta para el cliente, la idea seria escupirlo en json...
    public void verifyBuy(){

        ConnectionUrlParser.Pair<Integer,Integer> randomPair = pedidoRopa();
        JDBCHelper sql = new JDBCHelper();
        System.out.println(randomPair.right);
        ArrayList<Products> product = sql.searchProducts(2);//randomPair.right
        System.out.println("Pedido de "+randomPair.left+" "+product.get(0).getProduct_name());
        //System.out.println(product.get(0).getProduct_ID());

        if(randomPair.left > product.get(0).getQuantity()){
            System.out.println("No contamos con tantos ejemplares. Pruebe de nuevo...");
        }else {
            System.out.println("Total: "+product.get(0).getPrice()*randomPair.left);
        }
    }

}
