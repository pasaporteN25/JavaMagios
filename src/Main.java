import helpers.JDBCHelper;
import helpers.csvHelper;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //JDBCHelper sqlH = new JDBCHelper();
        //Scanner in = new Scanner(System.in);
        //csvHelper csvhelper = new csvHelper();

        //Inicio:
        cui consola = new cui();
        Boolean exit=false;

        while(!exit){

            exit = consola.welcomeScreen();
        }
    }
}
