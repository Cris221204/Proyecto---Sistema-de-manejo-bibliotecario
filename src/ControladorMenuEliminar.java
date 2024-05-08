import java.util.*;
public class ControladorMenuEliminar implements Controller {
    Scanner leer = new Scanner(System.in);
    ConsoleReader con=new ConsoleReader();
    @Override
    public void execute() {
        Menu menu = new Menu();
        int n=0;do{
        menu.addMenuItem(1, new MenuItem("ELIMINAR CLIENTE", this::ELIMINARCLIENTE));
        menu.addMenuItem(2, new MenuItem("ELIMINAR AUTOR", this::ELIMINARAUTORES));
        menu.addMenuItem(3, new MenuItem("ELIMINAR LIBRO", this::ELIMINARLIBROS));
        menu.addMenuItem(4,new MenuItem("CERRAR SESION",this::CERRARSESION));
        menu.display();
    }while(n!=0);
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
     ControladorMenuEliminar z=new ControladorMenuEliminar();
     z.execute();
    }
    public void ELIMINARLIBROS(){
        for (Book boors : RepositoryBook.books) {
            int d = boors.getPublishDate().day;
            int m = boors.getPublishDate().month;
            int y = boors.getPublishDate().year;
            String publish1 = d + "/" + m + "/" + y;
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                    boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        StringValidator in = s -> s.matches("\\d+");
        String isbn1 = con.ReadString("Isbn", in);
        for (int i = 0; i < RepositoryBook.books.size(); i++) {
            if (RepositoryBook.books.get(i).isAvailable) {
                if (RepositoryBook.books.get(i).isbn.equals(isbn1)) {
                    RepositoryBook.books.remove(i);
                }
            }
        }
        System.out.println("===LIBRO ELIMINADO===");
        ControladorMenuEliminar z=new ControladorMenuEliminar();
        z.execute();
    }
    public void ELIMINARAUTORES(){
        for (Author autors : RepositoryProfile.cl) {
            String book2 = "";
            for (Book autore : autors.getAuthor()) {
                book2 += autore.title + "|";
            }
            int day = autors.getProfile().birthdate.day;
            int mon = autors.getProfile().birthdate.month;
            int yea = autors.getProfile().birthdate.year;
            String Birthdate = day + "/" + mon + "/" + yea;
            System.out.println("--------------------------------------------");
            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s| ",
                    autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
            System.out.println("");
            System.out.println("--------------------------------------------");
        }
        System.out.print("Name: ");
        String namec2 = leer.nextLine();
        System.out.print("Last name: ");
        String lastc2 = leer.nextLine();

        for (int i = 0; i < RepositoryProfile.cl.size(); i++) {
            if (RepositoryProfile.cl.get(i).getProfile().name.equals(namec2) && RepositoryProfile.cl.get(i).getProfile().lastName.equals(lastc2)) {
                RepositoryProfile.cl.remove(i);
            }
        }
        System.out.println("===AUTOR ELIMINADO===");
        ControladorMenuEliminar z=new ControladorMenuEliminar();
        z.execute();
    }
    public void CERRARSESION(){
        Login login = new Login();
        login.execute();
    }
    /////////////case/////////////////////
    public void eliminar() {
        ConsoleReader con=new ConsoleReader();
        Scanner leer = new Scanner(System.in);
        int n;
        do {
            System.out.println("1) Eliminar clientes");
            System.out.println("2) Eliminar libros");
            System.out.println("3) Eliminar autores");
            System.out.println("4) Cerrar sesion");
            System.out.print("Escoge una opcion:");
            n = leer.nextInt();
            switch (n) {
                case 1:
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
                    break;
                case 2:
                    for (Book boors : RepositoryBook.books) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                    leer.nextLine();
                    StringValidator in = s -> s.matches("\\d+");
                    String isbn1 = con.ReadString("Isbn", in);
                    for (int i = 0; i < RepositoryBook.books.size(); i++) {
                        if (RepositoryBook.books.get(i).isAvailable) {
                            if (RepositoryBook.books.get(i).isbn.equals(isbn1)) {
                                RepositoryBook.books.remove(i);
                            }
                        }
                    }
                    break;
                case 3:
                    for (Author autors : RepositoryProfile.cl) {
                        String book2 = "";
                        for (Book autore : autors.getAuthor()) {
                            book2 += autore.title + "|";
                        }
                        int day = autors.getProfile().birthdate.day;
                        int mon = autors.getProfile().birthdate.month;
                        int yea = autors.getProfile().birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s| ",
                                autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
                        System.out.println("");
                        System.out.println("--------------------------------------------");
                    }
                    System.out.print("Name: ");
                    String namec2 = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc2 = leer.nextLine();

                    for (int i = 0; i < RepositoryProfile.cl.size(); i++) {
                        if (RepositoryProfile.cl.get(i).getProfile().name.equals(namec2) && RepositoryProfile.cl.get(i).getProfile().lastName.equals(lastc2)) {
                            RepositoryProfile.cl.remove(i);
                        }
                    }
                    break;
                case 4:
                    Login login = new Login();
                    login.execute();
                    break;
            }
        }while (n!=5);
    }


}
