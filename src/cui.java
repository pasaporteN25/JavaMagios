public class cui {

    public void welcomeScreen(){
        System.out.println("Bienvenido a su gestor de Stock");
        System.out.println("-------------------------------");
        System.out.println("");
        System.out.println("1.Consulta DB");
        System.out.println("2. Consulta csv");
        System.out.println("3. Control de Stock");
        System.out.println("4. Resumen del dia");
        System.out.println("5. Salir");
    }

    public void dbScreen(){
        System.out.println("DB Controller");
        System.out.println("-------------");
        System.out.println("1. Ver productos y stock");
        System.out.println("2. Buscar en productos");
        System.out.println("3. Modificar entrada");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Atras");
    }

    public void csvScreen(){
        System.out.println("CSV Center");
        System.out.println("-----------");
        System.out.println("1. Ver csv");
        System.out.println("2. Modificar csv");
        System.out.println("3. Eliminar entrada en un csv");
        System.out.println("4.  ");
        System.out.println("5. Atras");

    }

}
