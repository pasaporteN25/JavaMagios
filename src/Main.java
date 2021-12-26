import dao.JDBCaoImp;
import helpers.JDBCHelper;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello Magios!");

        //csvHelper csvhelper = new csvHelper();
        //csvhelper.reader();

        JDBCaoImp sql1 = new JDBCaoImp();

        sql1.getProducts();
    }
}
