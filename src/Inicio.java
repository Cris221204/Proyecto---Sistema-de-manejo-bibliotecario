import java.util.*;
public class Inicio implements Controller {
    Scanner leer = new Scanner(System.in);
    @Override
    public void execute() {
        Menu menu = new Menu();
        int n = 0;
        do {
            menu.addMenuItem(1, new MenuItem("CLIENTES", this::client));
            menu.addMenuItem(2, new MenuItem("AUTORES", this::autor));
            menu.addMenuItem(3, new MenuItem("LIBROS", this::book));
            menu.addMenuItem(4, new MenuItem("PROFILES", this::pro));
            menu.addMenuItem(5, new MenuItem("TRANSACTIONS", this::tran));
            menu.addMenuItem(6, new MenuItem("CERRAR SESION", this::cerrar));
            menu.display();
        } while (n != 11);
    }

    public void client() {
        ControladorClient c= new ControladorClient();
        c.execute();
       /* System.out.println("===CLIENT===");
        ControladorClient client = new ControladorClient();
        client.pc();*/
    }

    public void autor() {
        System.out.println("===AUTHOR===");
        ControladorAuthor auti = new ControladorAuthor();
        auti.execute();
    }

    public void book() {
        System.out.println("===BOOK===");
        ControladorBook booki = new ControladorBook();
        booki.execute();
    }

    public void pro() {
        System.out.println("===PROFILE===");
        ControladorProfile profils = new ControladorProfile();
        profils.execute();
    }

    public void tran() {
        System.out.println("===TRANSACTION===");
        ControladorTransaction teis = new ControladorTransaction();
        teis.execute();
    }
    public void cerrar(){
        Login login=new Login();
        login.execute();
    }
    /////////////////case/////////////////////
    public void menus(){
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("===MENU===");
            System.out.println("1) Client");
            System.out.println("2) Author");
            System.out.println("3) Book");
            System.out.println("4) Profile");
            System.out.println("5) Transaction");
            System.out.println("6) Cerrar sesion");
            System.out.print("Dime que quieres hacer: ");
            opcion = leer.nextInt();
            switch (opcion) {

                case 1:
                    System.out.println("===CLIENT===");
                    ControladorClient client = new ControladorClient();
                    client.execute();
                    break;
                case 2:
                    System.out.println("===AUTHOR===");
                    ControladorAuthor auti=new ControladorAuthor();
                    auti.execute();
                    break;
                case 3:
                    System.out.println("===BOOK===");
                    ControladorBook booki=new ControladorBook();
                    booki.execute();
                    break;
                case 4:
                    System.out.println("===PROFILE===");
                    ControladorProfile profils = new ControladorProfile();
                    profils.execute();
                    break;
                case 5:
                    System.out.println("===TRANSACTION===");
                    ControladorTransaction teis=new ControladorTransaction();
                    teis.execute();
                    break;
                    case 6:
                        Login login=new Login();
                        login.execute();
                        break;
            }
        }while (opcion != 7) ;
    }


}
