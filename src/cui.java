import dao.JDBCHelper;
import entities.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class cui {

    Scanner in = new Scanner(System.in);
    String option;
    JDBCHelper sqlHelper = new JDBCHelper();

    public void welcomeScreen(){
        System.out.println("Bienvenido a su gestor de Stock");
        System.out.println("-------------------------------");
        System.out.println("1.Consulta DB");
        System.out.println("2. Consulta csv");
        System.out.println("3. Control de Stock");
        System.out.println("4. Resumen del dia");
        System.out.println("5. Salir");
        option = in.nextLine();

        switch (option){
            case "1" -> dbScreen();
            case "2" -> csvScreen();
            case "3" -> System.out.println("Espera...");
            case "4" -> System.out.println("Segui esperando..");
            case "5" -> welcomeScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public void dbScreen(){
        System.out.println("DB Controller Room");
        System.out.println("------------------");
        System.out.println("1. Productos");
        System.out.println("2. Clientes");
        System.out.println("3. Atras");

        option = in.nextLine();
        switch (option){
            case "1" ->dbProdScreen();
            case "2" ->dbCustScreen();
            case "3" ->welcomeScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    //Esta quiza se puede mejorar uniendola con prod
    public void dbCustScreen(){
        System.out.println("DB Controller");
        System.out.println("-------------");
        System.out.println("1. Ver clientes");
        System.out.println("2. Buscar en clientes");
        System.out.println("3. Insertar clientes");
        System.out.println("4. Modificar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("6. Atras");

        option = in.nextLine();
        switch (option){
            case "1" ->sqlHelper.getCustomers();
            case "2" ->{}
            case "3" ->{}
            case "4" ->{}
            case "5" ->{}
            case "6" ->welcomeScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public void dbProdScreen(){
        System.out.println("DB Controller");
        System.out.println("-------------");
        System.out.println("1. Ver productos y stock");
        System.out.println("2. Buscar en productos");
        System.out.println("3. Insertar producto");
        System.out.println("4. Modificar entrada");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Atras");


        switch (option) {
            case "1" -> sqlHelper.getProducts();
            case "2" -> {
                System.out.println("Ingrese nombre: ");
                ArrayList<Products> resul = sqlHelper.searchProducts(in.nextLine());
                for(Products prod : resul){
                    System.out.println("ID: "+prod.getProduct_ID() +" | "
                            +"Nombre: "+prod.getProduct_name()+" | "
                            +"Tipo: "+prod.getProduct_type());
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

                    list.add(new Products(type,name,size,colour,price,quantity,description));
                    //Seguir ingresando!?
                    System.out.println("Seguis ingresando? Y/n");
                    next = in.nextLine();
                }while (next.equals("n")||next.equals("N"));
                sqlHelper.setProducts(list);
            }
            case "4" -> System.out.println("Espera...");//modificar
            case "5" ->{
                //Esta todavia no hace nada
                sqlHelper.deleteProduct();
                System.out.println("Segui esperando..");
            }
            case "6" -> dbScreen();
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public void csvScreen(){
        System.out.println("CSV Center");
        System.out.println("-----------");
        System.out.println("1. Ver csv");
        //Mostrar los que tenemos guardados? Como??
        System.out.println("2. Modificar csv");
        System.out.println("3. Eliminar entrada en un csv");
        System.out.println("4.  ");
        System.out.println("5. Atras");
    }

}
