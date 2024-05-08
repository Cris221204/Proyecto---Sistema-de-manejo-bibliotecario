import java.util.*;

public class ControladorMenuEscribir implements Controller{
    ConsoleReader con= new ConsoleReader();
    Scanner leer = new Scanner(System.in);

    @Override
    public void execute() {
        Menu menu = new Menu();
        int n = 0;
        do {
            menu.addMenuItem(1, new MenuItem("CREAR CLIENTE", this::CREARCLIENTE));
            menu.addMenuItem(2, new MenuItem("CREAR LIBRO", this::CREARLIBRO));
            menu.addMenuItem(3, new MenuItem("CREAR AUTOR", this::CREARAUTOR));
            menu.addMenuItem(4, new MenuItem("CERRAR SESION", this::cerrar));
            menu.display();
        }while (n!=11);
    }

    public void CREARCLIENTE(){
        System.out.print("Name: ");
        String namec = leer.nextLine();
        System.out.print("Last name: ");
        String lastc = leer.nextLine();
        IntegerValidator id=(value)-> value > 0 && value <=31;
        int D= con.ReadInt("Day",id);
        IntegerValidator me=(value)-> value> 0&& value <=12;
        int M=con.ReadInt("Month",me);
        IntegerValidator ye=(value)->value> 0&& value<=9999;
        int Y= con.ReadInt("Year",ye);
        System.out.print("Username: ");
        String user = leer.nextLine();
        StringValidator cha = password -> password.length() >= 6;
        String pass = con.ReadString("Password", cha);
        Date birth = new Date(D, M, Y);
        Profile cliente = new Profile(namec, lastc, birth);
        Client cr = new Client(cliente, user, pass);
        cr.setProfile(cliente);
        RepositoryArrayAdClie.Adminycliente.add(cr);
        System.out.println("===Cliente creado con exito===");
        ControladorMenuEscribir n=new ControladorMenuEscribir();
        n.execute();
    }
    public void CREARLIBRO(){
        StringValidator in = s -> s.matches("\\d+");
        String isbn = con.ReadString("Isbn", in);
        System.out.print("title: ");
        String title = leer.nextLine();
        IntegerValidator id1=(value)-> value > 0 && value <=31;
        int Da= con.ReadInt("Day",id1);
        IntegerValidator me1=(value)-> value> 0&& value <=12;
        int Me=con.ReadInt("Month",me1);
        IntegerValidator ye1=(value)->value> 0&& value<=9999;
        int Ye= con.ReadInt("Year",ye1);
        Date publish = new Date(Da, Me, Ye);
        for (Author autors : RepositoryProfile.cl) {
            String book2 = "";
            for (Book autor : autors.getAuthor()) {
                book2 += autor.title + "|";
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
        System.out.print("Name author: ");
        String s = leer.nextLine();
        System.out.print("Lastname author: ");
        String z = leer.nextLine();
        for (Author pes : RepositoryProfile.cl) {
            if (pes.getProfile().name.equals(s) && pes.getProfile().lastName.equals(z)) {
                Book book1 = new Book(isbn, title, publish, pes, true);
                RepositoryBook.books.add(book1);
                pes.setAuthor(book1);
            }
        }
        System.out.println("===Libro creado===");
        ControladorMenuEscribir n=new ControladorMenuEscribir();
        n.execute();
    }
    public void CREARAUTOR(){
        leer.nextLine();
        System.out.print("Name: ");
        String nameau = leer.nextLine();
        System.out.print("Last name: ");
        String lastau = leer.nextLine();
        IntegerValidator id2=(value)-> value > 0 && value <=31;
        int D1= con.ReadInt("Day",id2);
        IntegerValidator me2=(value)-> value> 0&& value <=12;
        int M2=con.ReadInt("Month",me2);
        IntegerValidator ye2=(value)->value> 0&& value<=9999;
        int Y6= con.ReadInt("Year",ye2);
        Date birth1=new Date(D1,M2,Y6);
        Profile autor = new Profile(nameau, lastau, birth1);
        Author cel = new Author(autor);
        RepositoryProfile.cl.add(cel);
        System.out.println("Autor creado con exito");
        ControladorMenuEscribir n=new ControladorMenuEscribir();
        n.execute();

    }
    public void cerrar(){
        Login login = new Login();
        login.execute();
    }
    ////////////CASE////////////////////////
    public void escribir() {
        ConsoleReader con= new ConsoleReader();
        Scanner leer = new Scanner(System.in);
        int n;
        do {

            System.out.println("1) Crear cliente");
            System.out.println("2) Crear libro");
            System.out.println("3) Cerrar sesion");
            System.out.println("4) Crear Autor");

            System.out.print("Seleccione una opcion ");
            n = leer.nextInt();
            switch (n) {
                case 1:
                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc = leer.nextLine();
                    IntegerValidator id=(value)-> value > 0 && value <=31;
                    int D= con.ReadInt("Day",id);
                    IntegerValidator me=(value)-> value> 0&& value <=12;
                    int M=con.ReadInt("Month",me);
                    IntegerValidator ye=(value)->value> 0&& value<=9999;
                    int Y= con.ReadInt("Year",ye);
                    System.out.print("Username: ");
                    String user = leer.nextLine();
                    StringValidator cha = password -> password.length() >= 6;
                    String pass = con.ReadString("Password", cha);
                    Date birth = new Date(D, M, Y);
                    Profile cliente = new Profile(namec, lastc, birth);
                    Client cr = new Client(cliente, user, pass);
                    cr.setProfile(cliente);
                    RepositoryArrayAdClie.Adminycliente.add(cr);
                    System.out.println("===Cliente creado con exito===");
                    break;
                case 2:
                    leer.nextLine();
                    StringValidator in = s -> s.matches("\\d+");
                    String isbn = con.ReadString("Isbn", in);
                    System.out.print("title: ");
                    String title = leer.nextLine();
                    IntegerValidator id1=(value)-> value > 0 && value <=31;
                    int Da= con.ReadInt("Day",id1);
                    IntegerValidator me1=(value)-> value> 0&& value <=12;
                    int Me=con.ReadInt("Month",me1);
                    IntegerValidator ye1=(value)->value> 0&& value<=9999;
                    int Ye= con.ReadInt("Year",ye1);
                    Date publish = new Date(Da, Me, Ye);
                    for (Author autors : RepositoryProfile.cl) {
                        String book2 = "";
                        for (Book autor : autors.getAuthor()) {
                            book2 += autor.title + "|";
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
                    System.out.print("Name author: ");
                    String s = leer.nextLine();
                    System.out.print("Lastname author: ");
                    String z = leer.nextLine();
                    for (Author pes : RepositoryProfile.cl) {
                        if (pes.getProfile().name.equals(s) && pes.getProfile().lastName.equals(z)) {
                            Book book1 = new Book(isbn, title, publish, pes, true);
                            RepositoryBook.books.add(book1);
                            pes.setAuthor(book1);
                        }
                    }
                    break;
                case 3:
                    Login login = new Login();
                    login.execute();
                    break;
                case 4:
                    leer.nextLine();
                    System.out.print("Name: ");
                    String nameau = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastau = leer.nextLine();
                    IntegerValidator id2=(value)-> value > 0 && value <=31;
                    int D1= con.ReadInt("Day",id2);
                    IntegerValidator me2=(value)-> value> 0&& value <=12;
                    int M2=con.ReadInt("Month",me2);
                    IntegerValidator ye2=(value)->value> 0&& value<=9999;
                    int Y6= con.ReadInt("Year",ye2);
                    Date birth1=new Date(D1,M2,Y6);
                    Profile autor = new Profile(nameau, lastau, birth1);
                    Author cel = new Author(autor);
                    RepositoryProfile.cl.add(cel);
                    System.out.println("Autor creado con exito");
                    break;
            }
        } while (n != 5);
    }


}