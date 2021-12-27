import com.mysql.cj.conf.ConnectionUrlParser;
import entities.Products;

import java.util.Random;

public class randomBuyers {
    //log.info log.error

    //Deberia elegir un numero de id, sacarlo del csv y enviarlo a la db
    //O minimamente devolverlo al main y que ahi se mande a la db
    public ConnectionUrlParser.Pair<Integer, Integer> pedidoRopa(){
        //Random rand = new Random();
        //rand.setSeed(2L);
        //int randomTotal = rand.nextInt(100);

        int rand = (int) (Math.random() * ((30-1) +1));

        return new ConnectionUrlParser.Pair<>(rand,1);
    }
}
