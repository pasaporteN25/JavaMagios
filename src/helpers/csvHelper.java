package helpers;

import entities.Customers;
import entities.Products;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class csvHelper {


    public ArrayList<Object> csvReader(String finalPath) {

        //ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();

        ArrayList<Object> result = new ArrayList<>();

        //recibirla por program arguments JSON!
        ///Users/lfelici/Downloads/file.csv
        Path filePath = Paths.get("C:/Users/Lucas/Downloads/"+finalPath+".csv");

        try {
            BufferedReader br = Files.newBufferedReader(filePath);
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosDeLinea = linea.split(",");
                //ArrayList<String> datosTemp = new ArrayList<>(Arrays.asList(datosDeLinea));
                //datos.add(datosTemp);

                if(finalPath.equals("products")){

                    if (!datosDeLinea[0].equals("product_ID")) {
                        //Esto se puede mejorar pero tengo que saltarme el primer intento
                        Products actual = new Products();
                        System.out.println(datosDeLinea[0]);
                        actual.setProduct_ID(Integer.parseInt(datosDeLinea[0]));
                        actual.setProduct_name(datosDeLinea[1]);
                        actual.setProduct_type(datosDeLinea[2]);
                        actual.setSize(datosDeLinea[3]);
                        actual.setColour(datosDeLinea[4]);
                        actual.setPrice(Float.parseFloat(datosDeLinea[5]));
                        actual.setQuantity(Integer.parseInt(datosDeLinea[6]));
                        actual.setDescription(datosDeLinea[7]);

                        //Lo puedo mejorar haciendo un for()

                        result.add(actual);

                    }
                }
                //falta verificar por nombre y tipo si no existe ya!

                if(finalPath.equals("customers")){

                    if (!datosDeLinea[0].equals("customer_id")) {
                        Customers actual = new Customers();
                        actual.setCustomer_name(datosDeLinea[1]);
                        actual.setGender(datosDeLinea[2]);
                        actual.setAge(Integer.parseInt(datosDeLinea[3]));
                        actual.setHome_address(datosDeLinea[4]);
                        actual.setZip_code(Integer.parseInt(datosDeLinea[5]));
                        actual.setCity(datosDeLinea[6]);
                        actual.setState(datosDeLinea[7]);
                        actual.setCountry(datosDeLinea[8]);
                        result.add(actual);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(datos);

        return result;

    }
}