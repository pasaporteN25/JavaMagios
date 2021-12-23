import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class csvHelper {

    ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();

    public void reader() {


        ///Users/lfelici/Downloads/products.csv
        Path filePath = Paths.get("/Users/lfelici/Downloads/products.csv");

        try {
            BufferedReader br = Files.newBufferedReader(filePath);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosDeLinea = linea.split(",");

                ArrayList<String> datosTemp = new ArrayList<>();
                datosTemp.addAll(Arrays.asList(datosDeLinea));
                datos.add(datosTemp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(datos);

    }
}