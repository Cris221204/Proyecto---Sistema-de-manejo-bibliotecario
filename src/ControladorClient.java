import java.util.*;

public class ControladorClient implements Controller{
    Scanner leer=new Scanner(System.in);
    ConsoleReader cons = new ConsoleReader();
    @Override
    public void execute() {
        int n=0;
        Menu menu = new Menu();

        menu.addMenuItem(1, new MenuItem("CREAR CLIENTE", this::CREARCLIENTE));
        menu.addMenuItem(2, new MenuItem("EDITAR CLIENTE", this::ACTUALIZARCLIENTE));
        menu.addMenuItem(3, new MenuItem("ELIMINAR CLIENTE", this::ELIMINARCLIENTE));
        menu.display();

    }

    public void CREARCLIENTE(){
        System.out.print("Name: ");
        String namec = leer.nextLine();
        System.out.print("Last name: ");
        String lastc = leer.nextLine();
        IntegerValidator id=(value)-> value > 0 && value <=31;
        int D= cons.ReadInt("Day",id);
        IntegerValidator me=(value)-> value> 0&& value <=12;
        int M=cons.ReadInt("Month",me);
        IntegerValidator ye=(value)->value> 0&& value<=9999;
        int Y= cons.ReadInt("Year",ye);
        System.out.print("Username: ");
        String user = leer.nextLine();
        StringValidator cha = password -> password.length() >= 6;
        String pass = cons.ReadString("Password", cha);
        Date birth = new Date(D, M, Y);
        Profile cliente = new Profile(namec, lastc, birth);
        Client cr = new Client(cliente, user, pass);
        cr.setProfile(cliente);
        RepositoryArrayAdClie.Adminycliente.add(cr);
        System.out.println("===Cliente creado con exito===");
    }
    public void ACTUALIZARCLIENTE(){
        for (User clients : RepositoryArrayAdClie.Adminycliente) {
            if (clients instanceof Client) {
                Client clien = (Client) clients;
                String book = "";
                for (Book client : clien.getBorrowedBoooks()) {
                    book += client.title + "|";
                }
                int day = clien.getProfile().birthdate.day;
                int mon = clien.getProfile().birthdate.month;
                int yea = clien.getProfile().birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                        clien.getProfile().name, clien.getProfile().lastName, Birthdate, clients.username, book);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        System.out.print("Dame el nombre:");
        String nombre2 = leer.nextLine();
        System.out.print("Dame el apellido:");
        String apellido = leer.nextLine();
//Buscamos en el array los datos que ingrese el usuario para buscar el profile
        for (User cli : RepositoryArrayAdClie.Adminycliente) {
            if (cli instanceof Client) {
                Client tras = (Client) cli;
                if (tras.getProfile().name.equals(nombre2) && tras.getProfile().lastName.equals(apellido)) {
                    System.out.println("===Profile Reboot===");
                    System.out.print("Nombre: ");
                    String names = leer.nextLine();
                    System.out.print("Last name: ");
                    String last = leer.nextLine();
                    IntegerValidator id1=(value)-> value > 0 && value <=31;
                    int D1= cons.ReadInt("Day",id1);
                    IntegerValidator me1=(value)-> value> 0&& value <=12;
                    int M2=cons.ReadInt("Month",me1);
                    IntegerValidator ye1=(value)->value> 0&& value<=9999;
                    int Y3= cons.ReadInt("Year",ye1);
                    System.out.print("Username: ");
                    String user1 = leer.nextLine();
                    StringValidator chu = password -> password.length() >= 6;
                    String pass1 = cons.ReadString("Password", chu);
                    Date date = new Date(D1, M2, Y3);
                    tras.getProfile().name = names;
                    tras.getProfile().lastName = last;
                    tras.getProfile().birthdate = date;
                    tras.username = user1;
                    tras.password = pass1;
                    return;
                }
            }
        }
    }
    public void ELIMINARCLIENTE(){
        for (User clients : RepositoryArrayAdClie.Adminycliente) {
            if (clients instanceof Client) {
                Client clien = (Client) clients;
                String book = "";
                for (Book client : clien.getBorrowedBoooks()) {
                    book += client.title + "|";
                }
                int day = clien.getProfile().birthdate.day;
                int mon = clien.getProfile().birthdate.month;
                int yea = clien.getProfile().birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                        clien.getProfile().name, clien.getProfile().lastName, Birthdate, clients.username, book);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }
        }

        System.out.print("Name: ");
        String namec1 = leer.nextLine();
        System.out.print("Lastname:");
        String las = leer.nextLine();
        for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
            User usel = RepositoryArrayAdClie.Adminycliente.get(i);
            if (usel instanceof Client) {
                Client tu = (Client) usel;
                if (tu.getProfile().name.equals(namec1) && tu.getProfile().lastName.equals(las)) {
                    if (tu.getBorrowedBoooks().isEmpty()) {
                        RepositoryArrayAdClie.Adminycliente.remove(tu);

                    }
                }
            }
        }
        System.out.println("===CLIENTE ELIMINADO===");
    }
    //////////////CASE/////////////////
    public void pc() {
        Scanner leer = new Scanner(System.in);
        ConsoleReader cons = new ConsoleReader();
        System.out.println("1) Crear");
        System.out.println("2) Actualizar");
        System.out.println("3) Eliminar cliente");
        System.out.println("Escoja una opcion: ");
        int numero = leer.nextInt();
        leer.nextLine();
        switch (numero) {
            case 1:
                System.out.print("Name: ");
                String namec = leer.nextLine();
                System.out.print("Last name: ");
                String lastc = leer.nextLine();
                IntegerValidator id=(value)-> value > 0 && value <=31;
                int D= cons.ReadInt("Day",id);
                IntegerValidator me=(value)-> value> 0&& value <=12;
                int M=cons.ReadInt("Month",me);
                IntegerValidator ye=(value)->value> 0&& value<=9999;
                int Y= cons.ReadInt("Year",ye);
                System.out.print("Username: ");
                String user = leer.nextLine();
                StringValidator cha = password -> password.length() >= 6;
                String pass = cons.ReadString("Password", cha);
                Date birth = new Date(D, M, Y);
                Profile cliente = new Profile(namec, lastc, birth);
                Client cr = new Client(cliente, user, pass);
                cr.setProfile(cliente);
                RepositoryArrayAdClie.Adminycliente.add(cr);
                System.out.println("===Cliente creado con exito===");
                break;
            case 2:
                for (User clients : RepositoryArrayAdClie.Adminycliente) {
                    if (clients instanceof Client) {
                        Client clien = (Client) clients;
                        String book = "";
                        for (Book client : clien.getBorrowedBoooks()) {
                            book += client.title + "|";
                        }
                        int day = clien.getProfile().birthdate.day;
                        int mon = clien.getProfile().birthdate.month;
                        int yea = clien.getProfile().birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                                clien.getProfile().name, clien.getProfile().lastName, Birthdate, clients.username, book);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                }
                System.out.print("Dame el nombre:");
                String nombre2 = leer.nextLine();
                System.out.print("Dame el apellido:");
                String apellido = leer.nextLine();
//Buscamos en el array los datos que ingrese el usuario para buscar el profile
                for (User cli : RepositoryArrayAdClie.Adminycliente) {
                    if (cli instanceof Client) {
                        Client tras = (Client) cli;
                        if (tras.getProfile().name.equals(nombre2) && tras.getProfile().lastName.equals(apellido)) {
                            System.out.println("===Profile Reboot===");
                            System.out.print("Nombre: ");
                            String names = leer.nextLine();
                            System.out.print("Last name: ");
                            String last = leer.nextLine();
                            IntegerValidator id1=(value)-> value > 0 && value <=31;
                            int D1= cons.ReadInt("Day",id1);
                            IntegerValidator me1=(value)-> value> 0&& value <=12;
                            int M2=cons.ReadInt("Month",me1);
                            IntegerValidator ye1=(value)->value> 0&& value<=9999;
                            int Y3= cons.ReadInt("Year",ye1);
                            System.out.print("Username: ");
                            String user1 = leer.nextLine();
                            StringValidator chu = password -> password.length() >= 6;
                            String pass1 = cons.ReadString("Password", chu);
                            Date date = new Date(D1, M2, Y3);
                            tras.getProfile().name = names;
                            tras.getProfile().lastName = last;
                            tras.getProfile().birthdate = date;
                            tras.username = user1;
                            tras.password = pass1;
                            return;
                        }
                    }
                }
                break;
            case 3://Listo
                for (User clients : RepositoryArrayAdClie.Adminycliente) {
                    if (clients instanceof Client) {
                        Client clien = (Client) clients;
                        String book = "";
                        for (Book client : clien.getBorrowedBoooks()) {
                            book += client.title + "|";
                        }
                        int day = clien.getProfile().birthdate.day;
                        int mon = clien.getProfile().birthdate.month;
                        int yea = clien.getProfile().birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                                clien.getProfile().name, clien.getProfile().lastName, Birthdate, clients.username, book);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                }

                System.out.print("Name: ");
                String namec1 = leer.nextLine();
                System.out.println("Lastname");
                String las = leer.nextLine();
                for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
                    User usel = RepositoryArrayAdClie.Adminycliente.get(i);
                    if (usel instanceof Client) {
                        Client tu = (Client) usel;
                        if (tu.getProfile().name.equals(namec1) && tu.getProfile().lastName.equals(las)) {
                            if (tu.getBorrowedBoooks().isEmpty()) {
                                RepositoryArrayAdClie.Adminycliente.remove(tu);

                            }
                        }
                    }
                }
                break;
        }
    }


}