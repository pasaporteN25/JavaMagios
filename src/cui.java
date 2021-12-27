import helpers.JDBCHelper;
import entities.Customers;
import entities.Products;
import helpers.csvHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class cui {

    Scanner in = new Scanner(System.in);
    String option;
    JDBCHelper sqlHelper = new JDBCHelper();

    public Boolean welcomeScreen() {
        Boolean salir = false;
        System.out.println("Bienvenido a su gestor de Stock");
        System.out.println("-------------------------------");
        System.out.println("1. Consulta DB");
        System.out.println("2. Consulta csv");
        System.out.println("3. Control de Stock");
        System.out.println("4. Resumen del dia");
        System.out.println("5. Esperar pedidos...");
        //Sleep 30s y preguntar de nuevo que hacer...
        System.out.println("6. Salir");
        option = in.nextLine();

        switch (option) {
            case "1" -> dbScreen();
            case "2" -> csvScreen();
            case "3" -> System.out.println("Espera...");
            case "4" -> System.out.println("Segui esperando..");
            case "5" -> {
                for (int i = 0; i < 3; i++) {
                    randomBuyers randombuyer = new randomBuyers();
                    randombuyer.verifyBuy();
                    //Aca cuando entra un pedido hay que modificar el stock de una!! E informarlo

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                welcomeScreen();
            }
            case "6" -> salir = true;
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
        return salir;
    }

    public void dbScreen() {
        System.out.println("DB Controller Room");
        System.out.println("------------------");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Atras");

        option = in.nextLine();
        switch (option) {
            case "1" -> dbProdScreen();
            case "2" -> dbCustScreen();
            case "3" -> welcomeScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    //Esta quiza se puede mejorar uniendola con prod
    public void dbCustScreen() {
        System.out.println("DB Controller");
        System.out.println("-------------");
        System.out.println("1. Ver clientes");
        System.out.println("2. Buscar en clientes");
        System.out.println("3. Insertar clientes");
        System.out.println("4. Modificar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("6. Atras");

        option = in.nextLine();
        switch (option) {
            case "1" -> {
                ArrayList<Customers> customersList = sqlHelper.getCustomers();


                for (Customers customer : customersList) {

                    System.out.println("ID: " + customer.getCustomer_id() +
                            ", Nombre: " + customer.getCustomer_name() +
                            ", Genero: " + customer.getGender() +
                            ", Edad: " + customer.getAge() +
                            ", Codigo Postal: " + customer.getZip_code() +
                            ", Direccion: " + customer.getHome_address() +
                            ", " + customer.getCity() +
                            ", " + customer.getState() +
                            ", " + customer.getCountry()
                            + ".\n");


                }
            }
            case "2" -> {}
            case "3" -> {
                ArrayList<Customers> customersList = new ArrayList<>();
                String next;
                String name;
                String gender;
                int age;
                String home_add;
                int zip_code;
                String city;
                String state;
                String country;

                do {
                    System.out.println("Ingrese categoria: ");
                    name = in.nextLine();
                    System.out.println("Ingrese nombre: ");
                    gender = in.nextLine();
                    System.out.println("Ingrese tamaño: ");
                    age = in.nextInt();
                    System.out.println("Ingrese color: ");
                    home_add = in.nextLine();
                    System.out.println("Ingrese precio: ");
                    zip_code = in.nextInt();
                    System.out.println("Ingrese cantidad: ");
                    city = in.nextLine();
                    System.out.println("Ingrese descripcion: ");
                    state = in.nextLine();
                    System.out.println("Ingrese descripcion: ");
                    country = in.nextLine();

                    customersList.add(new Customers(name, gender, age, home_add, zip_code, city, state, country));
                    //Seguir ingresando!?
                    System.out.println("Seguis ingresando? Y/n");
                    next = in.nextLine();
                } while (next.equals("n") || next.equals("N"));
                sqlHelper.setCustomers(customersList);
            }
            case "4" -> {}
            case "5" -> {}
            case "6" -> welcomeScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public void dbProdScreen() {
        System.out.println("DB Controller");
        System.out.println("-------------");
        System.out.println("1. Ver productos y stock");
        //Separar el stock de aca??
        System.out.println("2. Buscar en productos");
        System.out.println("3. Insertar producto");
        System.out.println("4. Modificar entrada");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Atras");
        option = in.nextLine();

        switch (option) {
            case "1" -> {
                ArrayList<Products> productsList = sqlHelper.getProducts();
                for (Products product : productsList) {

                    System.out.println("ID: " + product.getProduct_ID() +
                            ", Nombre: " + product.getProduct_name() +
                            ", Tipo: " + product.getProduct_type() +
                            ", Talle: " + product.getSize() +
                            ", Color: " + product.getColour() +
                            ", Precio: " + product.getPrice() +
                            ", Stock: " + product.getQuantity() +
                            ", Descripcion: " + product.getDescription()
                            + ".\n");

                }
            }
            case "2" -> {
                System.out.println("Ingrese nombre: ");
                ArrayList<Products> resul = sqlHelper.searchProducts(in.nextLine());
                for (Products prod : resul) {
                    System.out.println("ID: " + prod.getProduct_ID() + " | "
                            + "Nombre: " + prod.getProduct_name() + " | "
                            + "Tipo: " + prod.getProduct_type());
                }
            }
            case "3" -> {

                //Esto se podria mejorar?
                ArrayList<Products> list = new ArrayList<>();
                String next;
                String type;
                String name;
                String size;
                String colour;
                float price;
                int quantity;
                String description;

                do {

                    System.out.println("Ingrese categoria: ");
                    type = in.nextLine();
                    System.out.println("Ingrese nombre: ");
                    name = in.nextLine();
                    System.out.println("Ingrese tamaño: ");
                    size = in.nextLine();
                    System.out.println("Ingrese color: ");
                    colour = in.nextLine();
                    //Agregar un try aca o probar si rompe!
                    System.out.println("Ingrese precio: ");
                    price = in.nextFloat();
                    System.out.println("Ingrese cantidad: ");
                    quantity = in.nextInt();
                    //
                    System.out.println("Ingrese descripcion: ");
                    description = in.nextLine();

                    list.add(new Products(type, name, size, colour, price, quantity, description));
                    //Seguir ingresando!?
                    System.out.println("Seguis ingresando? Y/n");
                    next = in.nextLine();
                } while (next.equals("n") || next.equals("N"));
                sqlHelper.setProducts(list);
            }
            case "4" -> System.out.println("Espera...");//modificar
            case "5" -> {
                //Esta todavia no hace nada
                sqlHelper.deleteProduct();
                System.out.println("Segui esperando..");
            }
            case "6" -> dbScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public void csvScreen() {
        csvHelper csvhelper = new csvHelper();

        System.out.println("CSV Center");
        System.out.println("-----------");
        System.out.println("1. Ver csv");
        //Mostrar los que tenemos guardados? Como??
        System.out.println("2. Modificar csv");
        System.out.println("3. Eliminar entrada en un csv");
        System.out.println("4. csv to DB");
        System.out.println("5. Atras");

        option = in.nextLine();
        switch (option){
            case "4" ->{
                System.out.println("Tipos admitidos: 'customers' y 'products'");
                String pathFile = in.nextLine();
                ArrayList<Object> listToDb = csvhelper.csvReader(pathFile);

                if(pathFile.equals("products")){
                    ArrayList<Products> toAddProducts = new ArrayList<>();
                    for (Object obj: listToDb){
                        Products prod = (Products) obj;
                        toAddProducts.add(prod);
                    }
                    sqlHelper.setProducts(toAddProducts);
                }else if(pathFile.equals("customers")){
                    ArrayList<Customers> toAddCustomers = new ArrayList<>();
                    for(Object obj : listToDb){
                        Customers cust = (Customers) obj;
                        toAddCustomers.add(cust);
                    }
                    sqlHelper.setCustomers(toAddCustomers);
                }
            }
            case "5" -> welcomeScreen();
        }
    }

}
