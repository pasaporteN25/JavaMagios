import com.mysql.cj.conf.ConnectionUrlParser;
import entities.Products;

import java.util.Random;

public class randomBuyers {
    //log.info log.error

    //Deberia elegir un numero de id, sacarlo del csv y enviarlo a la db
    //O minimamente devolverlo al main y que ahi se mande a la db
    public ConnectionUrlParser.Pair<Integer, Integer> pedidoRopa(){

        //Total del pedido:
        int totalRand = (int) (Math.random() * ((30-1) +1));

        //Id del pedido:
        int idRand = (int) (Math.random() * (1259-1)+1);

        return new ConnectionUrlParser.Pair<>(totalRand,idRand);
    }
}
